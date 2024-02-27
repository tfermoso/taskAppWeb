package com.ceica.tareasweb.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       request.getRequestDispatcher("login.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String user=request.getParameter("user");
        String pass=request.getParameter("password");
        if(user.contains("admin") & pass.equals("1234")){
            response.sendRedirect("admin");
        }else{
            request.setAttribute("mensaje","Usuario o Password incorrecto");
            request.getRequestDispatcher("login.jsp").forward(request,response);

        }
    }
}
