<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style>
body{text-align: center;
	 background-repeat:no-repeat;}
.marquee {background-color:burlywood;width:400px;height:100px;}
</style>
<body background="image/a3bbedd47cac817f3580f3b24b365ceb806f46b9.jpg@1320w_742h.webp.jpg">
<div id="time1">
				当前时间:
				<script>
				document.getElementById('time1').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());
				setInterval("document.getElementById('time1').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
				</script>
			</div>
<marquee behavior="scroll" direction="left">     
  <p id="time" style = "color:red;font-size: xx-large;" >
  </marquee>
  
<script type="text/javascript">
function time() {
    function format(i) {
        return (i < 5 ? "0" + i : i);
    }
    document.getElementById("time").innerHTML = "欢迎登陆新闻发布系统"
    
}
var interval = setInterval(time, 100);
</script>  
</body>
</html>
