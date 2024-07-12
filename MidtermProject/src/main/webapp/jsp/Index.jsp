<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.ycw.dao.AirDaoImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles/BasicStyle.css">
<title>空氣品質資料</title>
</head>
<body>
<div class="container">
    <h2>空氣品質資料</h2>
    <div class="form-wrapper">
        <form method="post" action="GetAirArea" class="query-form">
            選擇地區: 
            <select name="area">
                <option value="">請選擇地區</option>
                <c:forEach items="${areas}" var="area">
                    <option value="${area}">${area}</option>
                </c:forEach>
            </select>
            <input type="submit" value="查詢">
        </form>
    </div>
    <div>    
        <form method="post" action="CSVToDatabase" Enctype="Multipart/Form-Data">
            選擇檔案: 
            <input type="file" name="file">
            <input type="submit" value="上傳">
        </form>
        <form method="post" action="Truncate">
            <input type="submit" value="清空">
        </form>
    </div> 
    <div>
        <a href="GetAllAir">查詢所有資料</a>
        <a href="html/Insert.html">新增空氣品質資料</a>
    </div>
</div>
</body>
</html>
