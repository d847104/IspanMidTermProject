<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles/BasicSelectStyle.css">
<title>員工資料</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h2>空氣發布資料</h2>
<table>
	<tr><td>編號
		<td><input type="text" disabled value="${air.id}"/>
	<tr><td>發布時間
		<td><input type="text" disabled value="${air.publishtime}"/>
	<tr><td>地區
		<td><input type="text" disabled value="${air.area}"/>
	<tr><td>主要汙染物
		<td><input type="text" disabled value="${air.majorPollutant}"/>
	<tr><td>預報日期
		<td><input type="text" disabled value="${air.forecastDate}"/>
	<tr><td>空氣品質指標值
		<td><input type="text" disabled value="${air.aqi}"/>
	<tr><td>次要汙染物名稱
		<td><input type="text" disabled value="${air.minorPollutant}"/>
	<tr><td>次要汙染物
		<td><input type="text" disabled value="${air.minorPollutantAqi}"/>
	<tr><td>建立日期
		<td><input type="text" disabled value="${air.createtime}"/>
	<tr><td>預報文字
		<td><textarea readonly name="content" rows="8" cols="50">${air.content}</textarea>	
</table>
<div class="link-container">
    <a href="/MidtermProject/html/Index.html">返回首頁</a>
    <a href="/MidtermProject/GetAllAir">返回所有資料</a>
</div>
</div>
</body>
</html>