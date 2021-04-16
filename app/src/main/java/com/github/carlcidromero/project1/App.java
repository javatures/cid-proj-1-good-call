package com.github.carlcidromero.project1;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.WebResourceSet;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    public static Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) throws LifecycleException {
        log.info("Embedding Tomcat server");
        Tomcat server = new Tomcat();
        int port = 8080;
        String host = "/api";

        server.getConnector();
        server.setPort(port);
        log.info("Embedded Tomcat server");

        log.info("Setting up webapp");
        File contextPath = new File("app/src/main/webapp");

        Context context = server.addWebapp(host, contextPath.getAbsolutePath());
        WebResourceRoot root = new StandardRoot(context);
        String webAppMount = "/WEB-INF/classes";
        String base = new File("app/build/classes/java/main").getAbsolutePath();
        String internalPath = "/";
        WebResourceSet webResourceSet = new DirResourceSet(root, webAppMount, base, internalPath);

        context.setResources(root);
        root.addPreResources(webResourceSet);


        server.addServlet(host, "thoughtServlet", new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                resp.getWriter().println("Hello from thoughtServlet");
            }
        });

        context.addServletMappingDecoded("/thought", "thoughtServlet");
        server.start();
        server.getServer().await();
    

    }

}
