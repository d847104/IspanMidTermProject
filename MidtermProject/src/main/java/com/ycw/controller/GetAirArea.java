package com.ycw.controller;
import java.io.IOException;
import com.ycw.dao.AirDao;
import com.ycw.dao.AirDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GetAirArea")
public class GetAirArea extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetAirArea() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AirDao dao = new AirDaoImpl();
        try {
        	request.setAttribute("airs", dao.getArea(request.getParameter("area")));
		    request.getRequestDispatcher("/jsp/GetAllAir.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
