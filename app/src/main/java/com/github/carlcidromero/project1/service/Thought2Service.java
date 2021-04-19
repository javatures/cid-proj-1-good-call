package com.github.carlcidromero.project1.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.carlcidromero.project1.repository.ThoughtDao;
import com.github.carlcidromero.project1.repository.ThoughtDaoImpl;

public class Thought2Service extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ThoughtDao thoughtDao = new ThoughtDaoImpl();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            RestRequest restRequest = new RestRequest(req.getPathInfo());
            int id = restRequest.getId();

            if (id == 0) {
                out.println(objectMapper.writeValueAsString(thoughtDao.rememberAll()));
            } else {
                out.println(objectMapper.writeValueAsString(thoughtDao.remember(id)));
            }
        } catch (ServletException e) {
            resp.setStatus(400);
            resp.resetBuffer();
            e.printStackTrace();
            out.println(e);
        }
        out.close();

    }
}
