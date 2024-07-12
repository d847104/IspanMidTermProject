<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/MidtermProject/styles/BasicInsertStyle.css">
<meta charset="UTF-8">
<title>修改空氣資料</title>
<script src="/MidtermProject/script/validateForm.js"></script>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
	<h2>修改空氣資料</h2>
	<form name="airForm" method="post" action="/MidtermProject/Update" class="form-container" onsubmit="return validateForm()">
		<div class="inputDiv">
	        <label class="inputLable">編號</label>
			<input type="hidden" name="id" value="${air.id}"/>
	        <input type="text" disabled value="${air.id}"/>
	    </div>
		<div class="inputDiv">
	        <label class="inputLable">發布時間</label>
	        <input type="text" name="publishtime" value="${air.publishtime}"/>
	        <small>(請輸入日期格式: yyyy-MM-dd)</small>
	    </div>
	    <div class="inputDiv">
	        <label class="inputLable">空品區名稱</label>
	        <input type="text" name="area" value="${air.area}"/>
	    </div>
	    <div class="inputDiv">
	        <label class="inputLable">主要污染物</label>
	        <input type="text" name="majorpollutant" value="${air.majorPollutant}"/>
	    </div>
	    <div class="inputDiv">
	        <label class="inputLable">預報日期</label>
	        <input type="text" name="forecastdate" value="${air.forecastDate}"/>
	        <small>(請輸入日期格式: yyyy-MM-dd)</small>
	    </div>
	    <div class="inputDiv">
	        <label class="inputLable">空氣品質指標</label>
	        <input type="text" name="aqi" value="${air.aqi}"/>
	    </div>
	    <div class="inputDiv">
	        <label class="inputLable">次要污染物</label>
	        <input type="text" name="minorpollutant" value="${air.minorPollutant}"/>
	    </div>
	    <div class="inputDiv">
	        <label class="inputLable">次要污染物指標</label>
	        <input type="text" name="minorpollutantaqi" value="${air.minorPollutantAqi}"/>
	    </div>
	    <div class="inputDiv">
	        <label class="inputLable">建立日期</label>
	        <input type="hidden" name="createtime" value="${air.createtime}"/>
	        <input type="text" disabled value="${air.createtime}"/>
	    </div>
	    <div class="inputDiv">
	        <label class="inputLable">預報文字</label>
	        <textarea name="content" rows="8" cols="50">${air.content}</textarea>
	    </div>
	    <div>        
	    	<input type="submit" value="送出"/>
	    </div>
	</form>
</div>
		<div class="link-container">
		    <a href="/MidtermProject/GetAllAir">返回所有資料</a>
		    <a href="/MidtermProject/html/Index.html">返回首頁</a>
		</div>
</body>
</html>