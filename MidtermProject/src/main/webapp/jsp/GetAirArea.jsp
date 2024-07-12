<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.ycw.bean.AirBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles/BasicSelectStyle.css">
<title>空氣品質資料</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h2>空氣品質資料 - ${param.area}</h2>

<table border="1">
    <tr style="background-color:#a8fefa">
        <th>編號<th>發布時間<th>地區<th>主要汙染物<th>預報日期<th>空氣品質指標值<th>次要汙染物名稱<th>次要汙染物<th>預報文字<th>建立日期<th>修改<th>刪除
        <c:forEach items="${airs}" var="air" varStatus="s">
            <tr>
                <td><a href="/MidtermProject/GetAir?id=${air.id}">${air.id}</a>
                <td>${air.publishtime}
                <td>${air.area}
                <td>${air.majorPollutant}
                <td>${air.forecastDate}
                <td>${air.aqi}
                <td>${air.minorPollutant}
                <td>${air.minorPollutantAqi}
                <td>${air.content}
                <td>${air.createtime}
                <td><a href="/MidtermProject/UpdateAirData?id=${air.id}">修改</a>
                <td><a href="/MidtermProject/Delete?id=${air.id}">刪除</a>
                <c:set value="${s.count}" var="num" />
        </c:forEach>
</table>

<h3>共${num}筆資料</h3>
<a href="/MidtermProject/html/Index.html">返回首頁</a>
</div>
</body>
</html>
