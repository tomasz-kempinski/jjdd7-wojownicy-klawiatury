package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.dao.ReservationDaoBean;
import com.infoshareacademy.wojownicy.dao.UserDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.User;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class EmailService {
  private static final String mailTransportProtocol = "smtp";
  private Logger logger = LoggerFactory.getLogger(getClass().getName());
  private static final String deleteContent = "Drogi użytkowniku,<br><br>"
      + "Z przykrością informujemy, że wydarzenie należące do ulubionych '%s' zostało usunięte z serwisu przez administratora.<br><br>"
      + "Administratorzy serwisu 3cityevent";
  private static final String timedContent = "Drogi użytkowniku,<br><br>"
      + "Uprzejmie informujemy, że wydarzenie należące do ulubionych '%s' straciło ważność i zostało usunięte z ulubionych.<br><br>"
      + "Administratorzy serwisu 3cityevent";
  private static final String confirmContent = "Drogi użytkowniku, <br><br>"
      + "Dokonałeś rezerwacji na wydarzenie %s.<br><br>"
      + "Administratorzy serwisu 3cityevent";

  @EJB
  private UserDaoBean userDaoBean;

  @EJB
  private BookDaoBean bookDaoBean;

  @EJB
  private PropertiesService propertiesLoaderService;

  public void sendCancelReservationEmailToUser(Long id) {
    User user = userDaoBean.getUserById(id);
    try {
      sendCanceledReservationEmail(user.getEmail(), id);
    } catch (MessagingException | IOException e) {
      logger.error(e.getMessage());
    }
  }

  public void sendTimeoutReservationEmailToUser(Long id) {
    User user = userDaoBean.getUserById(id);
    try {
      sendTimedoutReservationEmail(user.getEmail(), id);
    } catch (MessagingException | IOException e) {
      logger.error(e.getMessage());
    }
  }

  public void sendReservationEmailToUser(Long id, Long bookId) {
    User user = userDaoBean.getUserById(id);
    try {
      sendReservationEmail(user.getEmail(), bookId);
    } catch (MessagingException | IOException e) {
      logger.error(e.getMessage());
    }
  }

  private void sendCanceledReservationEmail(String email, Long bookId)
      throws MessagingException, IOException {
    String to = email;
    Book book = bookDaoBean.getBookById(bookId);
    String subject = "3cityevent | Zmiana w Twoich ulubionych wydarzeniach";
    String content = String.format(deleteContent, book.getTitle());
    Session session = Session
        .getDefaultInstance(propertiesLoaderService.loadMailProperties(), null);
    MimeMessage message = new MimeMessage(session);
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    message.setSubject(subject);
    message.setContent(content, "text/html; charset=utf-8");
    Transport transport = session.getTransport(mailTransportProtocol);
    String username = propertiesLoaderService.loadCredentialsProperties()
        .getProperty("user.name");
    String password = propertiesLoaderService.loadCredentialsProperties()
        .getProperty("user.password");
    String server = propertiesLoaderService.loadServerProperties().getProperty("mail.smtp.host");
    transport.connect(server, username, password);
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
  }

  private void sendTimedoutReservationEmail(String email, Long bookId)
      throws MessagingException, IOException {
    String to = email;
    Book book = bookDaoBean.getBookById(bookId);
    String subject = "3cityevent | Zmiana w Twoich ulubionych wydarzeniach";
    String content = String.format(timedContent, book.getTitle());
    Session session = Session
        .getDefaultInstance(propertiesLoaderService.loadMailProperties(), null);
    MimeMessage message = new MimeMessage(session);
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    message.setSubject(subject);
    message.setContent(content, "text/html; charset=utf-8");
    Transport transport = session.getTransport(mailTransportProtocol);
    String username = propertiesLoaderService.loadCredentialsProperties()
        .getProperty("user.name");
    String password = propertiesLoaderService.loadCredentialsProperties()
        .getProperty("user.password");
    String server = propertiesLoaderService.loadServerProperties().getProperty("mail.smtp.host");
    transport.connect(server, username, password);
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
  }

  private void sendReservationEmail(String email, Long bookId)
      throws MessagingException, IOException {
    String to = email;
    Book book = bookDaoBean.getBookById(bookId);
    String subject = "3cityevent | Potwierdzenie rezerwacji";
    String content = String.format(confirmContent, book.getTitle());
    Session session = Session
        .getDefaultInstance(propertiesLoaderService.loadMailProperties(), null);
    MimeMessage message = new MimeMessage(session);
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    message.setSubject(subject);
    message.setContent(content, "text/html; charset=utf-8");
    Transport transport = session.getTransport(mailTransportProtocol);
    String username = propertiesLoaderService.loadCredentialsProperties()
        .getProperty("user.name");
    String password = propertiesLoaderService.loadCredentialsProperties()
        .getProperty("user.password");
    String server = propertiesLoaderService.loadServerProperties().getProperty("mail.smtp.host");
    transport.connect(server, username, password);
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
  }
}
