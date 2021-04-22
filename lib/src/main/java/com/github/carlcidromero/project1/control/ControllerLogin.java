package com.github.carlcidromero.project1.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.github.carlcidromero.project1.model.Person;

@WebServlet("/login")
public class ControllerLogin extends HttpServlet {

    // @Override
    // protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //     Person steve = new Person();
    //     steve.setId(1);
    //     steve.setUsername("steve");
    //     steve.setPassword("password");

    //     String person = req.getParameter("person");
    //     String password = req.getParameter("password");

    //     HttpSession httpSession = req.getSession();
    //     httpSession.setAttribute("person", steve.getUsername());
    //     httpSession.setAttribute("password", steve.getPassword());

    //     if(person.equals(steve.getUsername()) && password.equals(steve.getPassword())) {
    //         resp.sendRedirect("/headspace");
    //     } else {
    //         resp.sendRedirect("/lib");
    //     }

    // }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person steve = new Person();
        steve.setId(1);
        steve.setUsername("steve");
        steve.setPassword("password");

        String person = req.getParameter("person");
        String password = req.getParameter("password");

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("person", steve.getUsername());
        httpSession.setAttribute("password", steve.getPassword());

        if (person.equals(steve.getUsername()) && password.equals(steve.getPassword())) {
            resp.sendRedirect("/lib/headspace");
        }

        else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/lib");
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("Username and/or password is incorrect.");
            requestDispatcher.include(req, resp);
        }

    }

}
