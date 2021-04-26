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
import com.github.carlcidromero.project1.model.Headspace;

@WebServlet("/api/headspace")
public class ControllerApiHeadspace extends HttpServlet {
  
  DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    List<Headspace> headspaces = new ArrayList<>();
    headspaces = databaseConnector.viewHeadspaces();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(headspaces);
    resp.setContentType("application/json");
    resp.getWriter().print(jsonString);
    
  }

}
