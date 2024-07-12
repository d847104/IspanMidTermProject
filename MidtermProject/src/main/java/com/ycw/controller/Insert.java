package com.ycw.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.ycw.bean.AirBean;
import com.ycw.dao.AirDao;
import com.ycw.dao.AirDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AirDao dao = new AirDaoImpl();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			AirBean air = new AirBean();
			air.setPublishtime(new Date(dateFormat.parse(request.getParameter("publishtime")).getTime()));														  
			air.setArea(request.getParameter("area"));														  
			air.setMajorPollutant(request.getParameter("majorpollutant"));													  
			air.setForecastDate(new Date(dateFormat.parse(request.getParameter("forecastdate")).getTime()));														  
			air.setAqi(Integer.parseInt(request.getParameter("aqi")));														 
			air.setMinorPollutant(request.getParameter("minorpollutant"));
			air.setMinorPollutantAqi(Integer.parseInt(request.getParameter("minorpollutantaqi")));
			air.setContent( request.getParameter("content"));
			request.setAttribute("dataNum", dao.getInsert(air));
			request.getRequestDispatcher("/jsp/Insert.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
