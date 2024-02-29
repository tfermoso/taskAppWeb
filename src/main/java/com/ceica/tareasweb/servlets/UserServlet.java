package com.ceica.tareasweb.servlets;

import com.ceica.tareasweb.controller.TaskController;
import com.ceica.tareasweb.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userServlet", value = "/user")
public class UserServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String logoutParam = request.getParameter("logout");
        // Si el parámetro "logout" tiene el valor "salir"
        if ("salir".equals(logoutParam)) {
            // Obtener la sesión actual (creará una nueva si no existe)
            HttpSession session = request.getSession(false);
            if (session != null) {
                // Invalidar la sesión
                session.invalidate();
                // Redireccionar a la página de inicio de sesión, o donde corresponda
                response.sendRedirect(request.getContextPath() + "/");
            }
        } else {
            User user = (User) request.getSession().getAttribute("user");

            if (user == null) {
                response.sendRedirect("login");
            } else {

                if (user.getRol().getDescription().equals("user")) {
                    request.setAttribute("name", user.getUsername());
                    TaskController taskController=new TaskController();
                    taskController.userLogged=user;

                    request.getRequestDispatcher("user.jsp").forward(request, response);


                } else {
                    response.sendRedirect("admin");
                }
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}
