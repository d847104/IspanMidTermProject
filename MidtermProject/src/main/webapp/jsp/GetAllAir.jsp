<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.ycw.bean.AirBean,com.ycw.dao.AirDao,com.ycw.dao.AirDaoImpl"%>
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
<h2>空氣品質資料</h2>

<table border="1">
	<tr style="background-color:#a8fefa">
		<th>編號<th>發布時間<th>地區<th>主要汙染物<th>預報日期<th>空氣品質指標值<th>次要汙染物名稱<th>次要汙染物<th>預報文字<th>建立日期<th>修改<th>刪除
	<c:forEach items="${airs}" var="air" varStatus="s">
  		<tr><td><a href="/MidtermProject/GetAir?id=${air.id}">${air.id}</a>
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
	</c:forEach><p>
</table>

<div>
    <c:if test="${currentPage > 1}">
        <a href="?page=${currentPage - 1}" style="margin: 1px;padding: 1px">上一頁</a>
    </c:if>
    <c:forEach begin="1" end="${totalPages}" var="i">
        <c:choose>
            <c:when test="${i == currentPage}">
                <strong>${i}</strong>
            </c:when>
            <c:otherwise>
                <a href="?page=${i}" style="margin: 1px;padding: 1px">${i}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${currentPage < totalPages}">
        <a href="?page=${currentPage + 1}" style="margin: 1px;padding: 1px">下一頁</a>
    </c:if>
</div>

<h3>共${num}筆資料</h3>
<a href="/MidtermProject/html/Index.html">返回首頁</a>
</div>
</body>
</html>