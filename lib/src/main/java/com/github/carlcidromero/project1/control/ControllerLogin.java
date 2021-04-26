package com.github.carlcidromero.project1.control;

import java.io.IOException;

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
        
        // mock hard-coded person db begin
        Person steve = new Person();
        steve.setPersonId(1);
        steve.setPersonUsername("steve");
        steve.setPersonPassword("password");
        // mock hard-coded person db end

        // login authentication & authorization begin
        String personUsernameFromForm = req.getParameter("personUsername");
        String personPasswordFromForm = req.getParameter("personPassword");
        
        if(personUsernameFromForm.equals(steve.getPersonUsername()) && personPasswordFromForm.equals(steve.getPersonPassword())) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("personUsername", personUsernameFromForm);
            resp.sendRedirect("/lib/headspace.html");
        } else {
            resp.sendRedirect("/lib");
        }
        // login authentication & authorization end

        
    }
}
