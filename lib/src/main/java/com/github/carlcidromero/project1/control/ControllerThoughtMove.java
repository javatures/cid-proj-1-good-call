package com.github.carlcidromero.project1.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/thought/move")
public class ControllerThoughtMove extends HttpServlet {
  
  DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    int id = Integer.parseInt(req.getParameter("id"));
    String location = req.getParameter("location");
    databaseConnector.moveThought(id, location);
    resp.sendRedirect("/lib/headspace.html");

  }
  
}
