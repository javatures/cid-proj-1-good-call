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
import com.github.carlcidromero.project1.model.Thought;

@WebServlet("/thought")
public class ControllerThought extends HttpServlet {

    DatabaseConnector databaseConnector = DatabaseConnector.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Thought> thoughts = new ArrayList<>();
        thoughts = databaseConnector.rememberThoughts();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(thoughts);
        resp.setContentType("application/json");
        resp.getWriter().print(jsonString);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String thoughtTldr = req.getParameter("thoughtTldr");
        String thoughtLocation = req.getParameter("thoughtLocation");
        String thoughtFrame = req.getParameter("thoughtFrame");

        Thought thought = new Thought(0, thoughtTldr, thoughtLocation, thoughtFrame);

        databaseConnector.contemplateThought(thought);
        resp.sendRedirect("headspace.html");

    }
        
}
