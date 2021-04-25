package com.github.carlcidromero.project1.control;

import java.io.IOException;

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person steve = new Person();
        steve.setPersonId(1);
        steve.setPersonUsername("steve");
        steve.setPersonPassword("password");

        String person = req.getParameter("personUsername");
        String password = req.getParameter("personPassword");

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("personUsername", steve.getPersonUsername());
        httpSession.setAttribute("personPassword", steve.getPersonPassword());

        if (person.equals(steve.getPersonUsername()) && password.equals(steve.getPersonPassword())) {
            resp.sendRedirect("/lib/headspace.html");
        }

        else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        }

    }

}
