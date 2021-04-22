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
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    DatabaseConnector databaseConnector = new DatabaseConnector();
    List<Vibe> vibes = new ArrayList<>();
    vibes = databaseConnector.feelVibes();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(vibes);
    resp.setContentType("application/json");
    resp.getWriter().println((jsonString));

  }

}
