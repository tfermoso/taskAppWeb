package com.ceica.tareasweb.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "apiServlet", value = "/api")
public class ApiServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idtask=request.getParameter("idtask");
        PrintWriter out=response.getWriter();
        String respuesta="{\"msg\":\"tarea a borrar "+ idtask+" por la api\"}";
        out.write(respuesta);
    }
}
