package com.github.carlcidromero.project1.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.carlcidromero.project1.model.Thought;

@WebServlet("/thought/delete")
public class ControllerThoughtDelete extends HttpServlet {

  DatabaseConnector databaseConnector = DatabaseConnector.getInstance();
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    int thoughtId = Integer.parseInt(req.getParameter("thoughtId"));
    Thought thought = new Thought(thoughtId);

    databaseConnector.forgetThought(thought);
    resp.sendRedirect("/lib/headspace.html");

  }

}
