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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DatabaseConnector databaseConnector = new DatabaseConnector();
        List<Thought> thoughts = new ArrayList<>();
        thoughts = databaseConnector.rememberThoughts();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(thoughts);
        resp.setContentType("application/json");
        resp.getWriter().print(jsonString);

    }
        
}
