package com.infoshareacademy.wojownicy.processor;

import com.infoshareacademy.wojownicy.exception.UserFileNotFound;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;

@RequestScoped
public class FileUploadProcessor {

  private static final String SETTINGS_FILE = "settings.properties";

  public File uploadFile(Part filePart) throws IOException, UserFileNotFound {
    String fileName = Paths.get(filePart.getSubmittedFileName())
        .getFileName().toString();

    if (fileName == null || fileName.isEmpty()) {
      throw new UserFileNotFound("No user file has been uploaded");
    }

    File file = new File(getUploadFilesPath() + fileName);

    Files.deleteIfExists(file.toPath());

    InputStream fileContent = filePart.getInputStream();

    Files.copy(fileContent, file.toPath());

    return file;
  }

  public String getUploadFilesPath() throws IOException {
    Properties settings = new Properties();
    settings.load(Thread.currentThread()
        .getContextClassLoader().getResource(SETTINGS_FILE)
        .openStream());
    return settings.getProperty("Upload.Path.Files");
  }
}

