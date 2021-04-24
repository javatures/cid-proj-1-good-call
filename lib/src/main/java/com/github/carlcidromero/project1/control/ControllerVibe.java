package com.github.carlcidromero.project1.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.carlcidromero.project1.model.Vibe;

@WebServlet("/vibe")
public class ControllerVibe extends HttpServlet {

  DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<Vibe> vibes = new ArrayList<>();
    vibes = databaseConnector.feelVibes();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(vibes);
    resp.setContentType("application/json");
    resp.getWriter().println((jsonString));

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String tldr = req.getParameter("tldr");
    int soulId = Integer.parseInt(req.getParameter("soul"));
    String purpose = req.getParameter("purpose");

    Vibe vibe = new Vibe(0, soulId, tldr, purpose);

    databaseConnector.sendVibe(vibe);
    resp.sendRedirect("headspace.html");

  }

}
