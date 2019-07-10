<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body background="image/a3bbedd47cac817f3580f3b24b365ceb806f46b9.jpg@1320w_742h.webp.jpg">
<form  method="post" action="RegisteredSeverlet" id="f">
<p>账号：<input type="text" name="username" id="user" onblur="checkuser()"><label id="m"></label></p>
<p>密码：<input type="password" name="pass" id="pass"></p>
<p>确认密码：
  <label for="pass2"></label>
  <input type="password" name="repass" id="repass">
</p>
<p>性别：
	<input type="radio" name="sex" value="0">男
	<input type="radio" name="sex" value="1">女
</p>
<p>职业：
  <input type="radio" name="profession" id="radio" value="0">
  <label for="radio"></label>
学生
<input type="radio" name="profession" id="radio2" value="1">
<label for="radio2"></label>
老师
<input type="radio" name="profession" id="radio3" value="2">
<label for="radio3"></label>
工人</p>
<p>  
爱好：
	<input type="checkbox" name="favourite" value="0">
	电脑网络
	<input type="checkbox" name="favourite" value="1">
	影视娱乐
	<input type="checkbox" name="favourite" value="2">
	棋牌娱乐
</p>
<p>个人说明
	<textarea name="note" id="textarea" rows="5" cols="45"></textarea>
</p>
<p>
	<input type="submit" name="button" id="button" value="注册" onclick="check()">
	<input type="reset" name="button2" id="button2" value="重置">
</p>
</form>
<script type="text/javascript">
function checkpass(){
  var pass=document.getElementById("pass").value;
  var repass=document.getElementById("repass").value;	
  if(pass.length<6||pass.length>18){
	  alert("密码必须是6到18位");
  }else  if(pass!=repass){
	  alert("两次密码输入不一致");
  }else{
	 document.getElementById("f").submit(); 
  }
}
function check(){
	checkuser();
	checkpass();
	document.getElementById("f").submit;
	
}
function checkuser(){
	var user=document.getElementById("user").value;
	$.post("CheckUserServlet",{"user":user},function(data){
		if(user== ""){
			alert("用户名不能为空");
			$('form').submit(function(){//禁止表单提交
				return false;	
			});
		}
		else if(data=='success'){
			$("#m").text("可用");
			document.getElementById("btn").submit()
		}else{
			$("#m").text("不可用");
			alert("该用户名已存在");
			$('form').submit(function(){
			return false;
		});
	}
		
	});
}
</script>
</body>
</html>