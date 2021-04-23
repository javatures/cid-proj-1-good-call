package com.github.carlcidromero.project1.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("vibe/delete")
public class ControllerVibeDelete extends HttpServlet {
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    DatabaseConnector databaseConnector = new DatabaseConnector();

  }
  
}
