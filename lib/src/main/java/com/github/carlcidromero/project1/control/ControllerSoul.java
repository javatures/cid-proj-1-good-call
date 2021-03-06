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
import com.github.carlcidromero.project1.model.Soul;

@WebServlet("/soul")
public class ControllerSoul extends HttpServlet {

  DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    List<Soul> souls = new ArrayList<>();
    souls = databaseConnector.observeSouls();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(souls);
    resp.setContentType("application/json");
    resp.getWriter().print(jsonString);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String soulName = req.getParameter("soulName");

    Soul soul = new Soul(0, soulName);

    databaseConnector.touchSoul(soul);
    resp.sendRedirect("headspace.html");

  }
  
}
