package com.infoshareacademy.wojownicy.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class LibraryManager {
  protected SessionFactory sessionFactory;

  protected void setup() {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure()
        .build();
    try {
      sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    } catch (Exception ex) {
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }

  protected void exit() {
    sessionFactory.close();
  }

  protected void create() {
    // code to save a book
  }

  protected void read() {
    // code to get a book
  }

  protected void update() {
    // code to modify a book
  }

  protected void delete() {
    // code to remove a book
  }

  public static void main(String[] args) {
    // code to run the program
  }
}
