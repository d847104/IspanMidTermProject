function validateForm() {
    const publishtime = document.forms["airForm"]["publishtime"].value;
    const area = document.forms["airForm"]["area"].value;
    const majorpollutant = document.forms["airForm"]["majorpollutant"].value;
    const forecastdate = document.forms["airForm"]["forecastdate"].value;
    const aqi = document.forms["airForm"]["aqi"].value;
    const minorpollutant = document.forms["airForm"]["minorpollutant"].value;
    const minorpollutantaqi = document.forms["airForm"]["minorpollutantaqi"].value;
    const content = document.forms["airForm"]["content"].value;

    const datePattern = /^\d{4}-\d{2}-\d{2}$/;
    const numberPattern = /^\d+$/;

    if (!publishtime.match(datePattern)) {
        alert("發布時間格式錯誤，請輸入 yyyy-MM-dd 格式的日期");
        return false;
    }
    if (area.trim() === "") {
        alert("空品區名稱不能為空");
        return false;
    }
    if (majorpollutant.trim() === "") {
        alert("主要污染物不能為空");
        return false;
    }
    if (!forecastdate.match(datePattern)) {
        alert("預報日期格式錯誤，請輸入 yyyy-MM-dd 格式的日期");
        return false;
    }
    if (!aqi.match(numberPattern)) {
        alert("空氣品質指標必須是數字");
        return false;
    }
    if (minorpollutant.trim() === "") {
        alert("次要污染物不能為空");
        return false;
    }
    if (!minorpollutantaqi.match(numberPattern)) {
        alert("次要污染物指標必須是數字");
        return false;
    }
    if (content.trim() === "") {
        alert("預報文字不能為空");
        return false;
    }
    return true;
}
