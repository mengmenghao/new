<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cn.vo.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<style type="text/css">
.ziti {
	color: #FFF;
}
ziti {
	color: #FFF;
}
body p {
	color: #FFF;
	font-family: "方正舒体";
	font-weight: bold;
}
a{
	text-decoration:none;
	color:#333;
}
</style>
</head>
<body background="image/a3bbedd47cac817f3580f3b24b365ceb806f46b9.jpg@1320w_742h.webp.jpg">
<%User u=(User)session.getAttribute("user");
  String type=u.getType();
  if(type.equals("0")){
%>
<p align="center"><a href="newsManager.jsp" target="mainFrame">新闻管理</a></p>
<p align="center"><a href="user.jsp" target="mainFrame">个人中心</a></p>
<p align="center"><a href="changepassword.jsp" target="mainFrame">修改密码</a></p>
<p align="center"><a href="Login.jsp" target="_top">退出登录</a></p>
<%}else{ %>
<p align="center"><a href="newsManager.jsp" target="mainFrame">新闻管理</a></p>
<p align="center"><a href="usermanagement.jsp" target="mainFrame">用户管理</a></p>
<p align="center"><a href="changepassword.jsp" target="mainFrame">修改密码</a></p>
<p align="center"><a href="Login.jsp" target="_top">退出登录</a></p>
<%} %>
</body>
</html>
