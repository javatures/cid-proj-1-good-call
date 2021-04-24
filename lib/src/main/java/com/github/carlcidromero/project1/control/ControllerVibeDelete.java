package com.github.carlcidromero.project1.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.carlcidromero.project1.model.Vibe;

@WebServlet("/vibe/delete")
public class ControllerVibeDelete extends HttpServlet {

  DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    int id = Integer.parseInt(req.getParameter("id"));
    Vibe vibe = new Vibe(id);

    databaseConnector.cancelVibe(vibe);
    resp.sendRedirect("/lib/headspace.html");

  }
  
}
