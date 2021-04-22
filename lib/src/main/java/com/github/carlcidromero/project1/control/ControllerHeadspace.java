package com.github.carlcidromero.project1.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/headspace")
public class ControllerHeadspace extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    HttpSession httpSession = req.getSession();

    String person = httpSession.getAttribute("person").toString();
    
    PrintWriter printWriter = resp.getWriter();
    printWriter.print("Hello " + person);
  }

}
