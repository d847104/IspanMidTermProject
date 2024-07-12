package com.ycw.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ycw.bean.AirBean;
import com.ycw.dao.AirDao;
import com.ycw.dao.AirDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/CSVToDatabase")
@MultipartConfig(location = "c:/Servlet/workspace/MidtermProject/src/main/webapp/data/")
public class CSVToDatabase extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Part p = request.getPart("file");
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(p.getInputStream(), "BIG5"))) {
            String[] values;
            // Skip the header
            csvReader.readNext();

            AirDao airDao = new AirDaoImpl();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            int dataNum = 0;

            while ((values = csvReader.readNext()) != null) {
                AirBean airQuality = new AirBean();
                airQuality.setContent(values[0]);
                airQuality.setPublishtime(new Date(dateFormat.parse(values[1]).getTime()));
                airQuality.setArea(values[2]);
                airQuality.setMajorPollutant(values[3] != "" ? values[3] : "");
                airQuality.setForecastDate(new Date(dateFormat.parse(values[4]).getTime()));
                airQuality.setAqi(Integer.parseInt(values[5]));
                airQuality.setMinorPollutant(values[6] != "" ? values[6] : "");
                airQuality.setMinorPollutantAqi(values[7] != "" ? Integer.parseInt(values[7]) : 0);

                dataNum += airDao.getInsert(airQuality);
            }

            request.setAttribute("dataNum", dataNum);
    	    request.getRequestDispatcher("/jsp/CSVToDatabase.jsp").forward(request, response);
        } catch (IOException | ParseException | CsvValidationException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred: " + e.getMessage());
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
