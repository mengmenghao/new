<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
.yh {
	font-family: "华文琥珀";
	font-size: 36px;
	color: #333;
}
</style>
</head>
<body>
<form  method="post" name="form1">
<p align="center" class="yh">用户登录</p>
<table width="342" border="1" align="center">
  <tr>
    <th width="125" height="42" bgcolor="#99FFFF" scope="row">用户名：</th>
    <td colspan="2"><input type="text" name="user" id="user" ></td>
    </tr>
  <tr>
    <th height="38" bgcolor="#00FFFF" scope="row">密码：</th>
    <td colspan="2"><input type="password" name="pass" id="pass"></td>
    </tr>
  <tr>
    <th height="42" bgcolor="#00FFFF" scope="row">用户类型：</th>
    <td colspan="2"><select name="type">
      <option value="0">普通用户</option>
      <option value="1">管理员</option>
    </select></td>
    </tr>
  <tr>
    <th height="36" bgcolor="#00FFFF" scope="row"><input name="button" type="submit" onClick="check()" value="登录"></th>
    <td width="96" align="center" valign="middle" bgcolor="#00FFFF"><input type="submit" name="button" id="button2" onClick="re()" value="注册"></td>
    <td width="99" align="center" valign="middle" bgcolor="#00FFFF"><input type="reset" value="重置"></td>
  </tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</form>

</body>
<script type="text/javascript">
function check(){
var user=document.getElementById("user").value;
var pass=document.getElementById("pass").value;

if(user==""||pass==""){
	alert("用户名或者密码不能为空")
}else{
//var form=document.getElementById("Myform");
form1.action="LoginSeverlet";
form1.submit();
}
}
function re(){
	//var form=document.getElementById("Myform");
	form1.action="register.jsp";
	form1.submit();
}

</script>
</html>