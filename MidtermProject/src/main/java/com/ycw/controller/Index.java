package com.ycw.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ycw.dao.AirDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;   
    public Index() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AirDaoImpl airDao = new AirDaoImpl();
	    List<String> areas = new ArrayList<>();
	    try {
	        areas = airDao.getAllAreas();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    request.setAttribute("areas", areas);
	    request.getRequestDispatcher("/jsp/Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
