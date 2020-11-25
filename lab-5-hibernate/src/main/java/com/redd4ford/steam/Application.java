package com.redd4ford.steam;

import com.redd4ford.steam.util.HibernateUtil;
import com.redd4ford.steam.view.View;
import org.hibernate.Session;

public class Application {

  public static void main(String[] args) {
    try (Session SESSION = HibernateUtil.getSession()) {
      System.out.println("Test session established. ");
      new View().show();
    } catch (Throwable ex) {
      System.err.println("Test session failed.");
      ex.printStackTrace();
    }
  }
}
