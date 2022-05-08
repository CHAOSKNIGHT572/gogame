package com.example.gogame;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.json.JSONObject;

@WebServlet(name = "helloServlet", value = "/game")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String gamename = request.getParameter("gamename");
        response.getWriter().println("Game is " + gamename);
    }

    public void destroy() {
    }
}