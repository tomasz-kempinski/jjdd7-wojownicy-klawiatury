package com.infoshareacademy.wojownicy.processor;

import com.infoshareacademy.wojownicy.exception.UserImageNotFound;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ImageUploadProcessor {

  private static final Logger logger = LoggerFactory
      .getLogger(ImageUploadProcessor.class.getName());

  public File uploadImageFile(Part filePart, Long id) throws IOException, UserImageNotFound {

    String fileName = Paths.get(filePart.getSubmittedFileName())
        .getFileName().toString();

    if (fileName == null || fileName.isEmpty()) {
      throw new UserImageNotFound("No user image has been uploaded");
    }

    String changedFileName = id + "." + FilenameUtils.getExtension(fileName);

    File file = new File(getUploadImageFilesPath() + changedFileName);

    Files.deleteIfExists(file.toPath());

    InputStream fileContent = filePart.getInputStream();

    Files.copy(fileContent, file.toPath());

    fileContent.close();

    return file;
  }

  public String getUploadImageFilesPath() throws IOException {
    return createImagePathDirectory();
  }

  private String createImagePathDirectory() {
    String url;
    url = System.getenv("HOME");
    Path path = Paths.get(url + "/media/");
    if (!Files.exists(path)) {
      try {
        Files.createDirectories(path);
        logger.info("New path directory for images has been created");
      } catch (IOException e) {
        e.getMessage();
        logger.warn("Failed to create path directory for images");
      }
    }
    return path.toString() + "/";
  }
}