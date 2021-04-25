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

    int vibeId = Integer.parseInt(req.getParameter("vibeId"));
    Vibe vibe = new Vibe(vibeId);

    databaseConnector.cancelVibe(vibe);
    resp.sendRedirect("/lib/headspace.html");

  }
  
}
