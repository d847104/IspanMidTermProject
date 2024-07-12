package com.ycw.controller;

import java.io.IOException;
import java.sql.Connection;

import com.ycw.dao.AirDao;
import com.ycw.dao.AirDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GetAir")
public class GetAir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
    public GetAir() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		AirDao dao = new AirDaoImpl();
		try {
			request.setAttribute("air", dao.getOne(Integer.parseInt(id)));
			request.getRequestDispatcher("/jsp/GetAir.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
