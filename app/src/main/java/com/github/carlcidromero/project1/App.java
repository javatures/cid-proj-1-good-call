package com.github.carlcidromero.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        System.out.println(new App().getGreeting());

    }

}
