package com.ycw.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.ycw.bean.AirBean;
import com.ycw.dao.AirDao;
import com.ycw.dao.AirDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GetAllAir")
public class GetAllAir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;   
    public GetAllAir() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AirDao dao = new AirDaoImpl();
		try {
			// 分頁參數
		    int pageSize = 50;
		    int currentPage = 1;
		    if (request.getParameter("page") != null) {
		        currentPage = Integer.parseInt(request.getParameter("page"));
		    }
		    int offset = (currentPage - 1) * pageSize;

		    List<AirBean> airList = dao.getAllPaged(offset, pageSize);
		    int totalRecords = dao.getTotalCount();
		    int totalPages = (int) Math.ceil((double) totalRecords / pageSize);

		    request.setAttribute("airs", airList);
		    request.setAttribute("totalPages", totalPages);
		    request.setAttribute("currentPage", currentPage);
		    request.setAttribute("num", dao.getAll());
		    request.getRequestDispatcher("/jsp/GetAllAir.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
