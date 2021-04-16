package com.github.carlcidromero.project1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;

public class RestRequest {
    private Pattern regExThoughtAll = Pattern.compile("/thought");
    private Pattern regExThoughtId = Pattern.compile("/thought/([0-9]*)");

    private int id;

    public RestRequest(String path) throws ServletException {
        Matcher matcher = regExThoughtId.matcher(path);
        if (matcher.find()) {
            id = Integer.parseInt(matcher.group(1));
            return;
        }

        matcher = regExThoughtAll.matcher(path);
        if (matcher.find()) return;

        throw new ServletException("Invalid URI");
    }

    public int getId() {
        return id;
    }
}
