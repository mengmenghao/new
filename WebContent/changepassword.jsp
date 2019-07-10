<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.ziti {
	font-weight: bold;
}
.ziti p {
	color: #F00;
}
</style>
</head>
<body background="image/a3bbedd47cac817f3580f3b24b365ceb806f46b9.jpg@1320w_742h.webp.jpg">
<form name="form1" method="post" action="PasswordUserServlet">
  <div align="center" class="ziti">
    <p>修改密码</p>
    <p>原密码：
      <label for="textfield"></label>
      <input type="password" name="password" id="password" placeholder="请输入原密码">
      <input type="button" name="btn" id="show" value="点击显示" onClick="showPass()" style="background-color:transparent;
	 background-repeat:no-repeat;
	  border:none; 
	  cursor:pointer;
	  overflow:hidden">
    </p>
    <p>新密码：
      <label for="textfield2"></label>
      <input type="password" name="password2" id="password2" placeholder="请输入新密码">
      <input type="button" name="btn2" id="show2" value="点击显示" onClick="showPass2()" style="background-color:transparent;
	 background-repeat:no-repeat;
	  border:none; 
	  cursor:pointer;
	  overflow:hidden">
    </p>
    <p>确认密码：
      <label for="textfield2"></label>
      <input type="password" name="password3" id="password3" placeholder="请再次输入新密码">
      <input type="button" name="btn2" id="show3" value="点击显示" onClick="showPass3()" style="background-color:transparent;
	 background-repeat:no-repeat;
	  border:none; 
	  cursor:pointer;
	  overflow:hidden">
  </p>
    </p>
    <p>
      <input type="submit" name="button" id="button" value="确定" onclick="checkpass()">
        <input type="reset" name="button2" id="button2" value="重置">
      <input type="button" name="button3" id="button3" value="按钮">
    </p>
  </div>
</form>
<script type="text/javascript">
function showPass(){
	   var btn = document.getElementById("show")
	   var pass = document.getElementById("password")
if(btn.value == "点击显示"){
	  pass.type = "text" 
	  btn.value = "点击隐藏"
	  }else if(btn.value == "点击隐藏"){
		 pass.type = "password" 
	 	 btn.value = "点击显示" 
		  }
}
function showPass2(){
	   var btn2 = document.getElementById("show2")
	   var pass2 = document.getElementById("password2")
if(btn2.value == "点击显示"){
	  pass2.type = "text" 
	  btn2.value = "点击隐藏"
	  }else if(btn2.value == "点击隐藏"){
		 pass2.type = "password" 
	 	 btn2.value = "点击显示" 
		  }
}
function showPass3(){
	   var btn3 = document.getElementById("show3")
	   var pass3 = document.getElementById("password3")
if(btn3.value == "点击显示"){
	  pass3.type = "text" 
	  btn3.value = "点击隐藏"
	  }else if(btn3.value == "点击隐藏"){
		 pass3.type = "password" 
	 	 btn3.value = "点击显示" 
		  }
}
function checkpass(){
  var password2=document.getElementById("password2").value;
  var password3=document.getElementById("password3").value;	
  if(password2.length<6||password2.length>18){
	  alert("密码必须是6到18位");
  }else  if(password2!=password3){
	  alert("两次密码输入不一致");
  }else{
	 document.getElementById("form1").submit(); 
  }
}

</script>
</body>
</html>