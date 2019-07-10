<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cn.vo.User,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.s {
	color: #F00;
}
</style>
</head>
<body background="image/a3bbedd47cac817f3580f3b24b365ceb806f46b9.jpg@1320w_742h.webp.jpg">
<%User user=(User)session.getAttribute("user");
%>
<form name="form1" method="post" action="UserxingxiServlet">
  <div align="center">
    <table width="720" border="1">
      <tr bgcolor="#FF0000">
        <th colspan="3" scope="row">个人信息</th>
      </tr>
      <tr>
        <th width="129" bgcolor="#FF0000" scope="row">姓名</th>
        <td width="510" colspan="2" bgcolor="#0000FF"><label for="textfield"></label>
        <input type="text" name="username" id="username" value="<%=user.getUsername() %>">
     	</td>
      </tr>
      <tr>
        <th bgcolor="#FF0000" scope="row">权限</th>
        <td colspan="2" bgcolor="#0000FF"><%=user.getType() %>
        <label for="textfield3"></label></td>
      </tr>
      <tr>
        <th bgcolor="#FF0000" scope="row">性别</th>
        <td colspan="2" bgcolor="#0000FF">
          <label for="textfield4"></label>
        <input type="text" name="sex" id="sex" value="<%=user.getSex() %>">
        0：男生，1：女生</td>
      </tr>
      <tr>
        <th bgcolor="#FF0000" scope="row">职业</th>
        <td colspan="2" bgcolor="#0000FF">
          <label for="textfield5"></label>
        <input type="text" name="profession" id="profession"  value="<%=user.getProfession()%>">
        0：学生，1：老师，2：工人</td>
      </tr>
      <tr>
        <th bgcolor="#FF0000" scope="row">兴趣爱好</th>
        <td colspan="2" bgcolor="#0000FF">
          <label for="textfield6"></label>
        <input type="text" name="favourite" id="favourite" value="<%=user.getFavourite() %>">
        0：电脑网络，1：影视娱乐，2：棋牌娱乐</td>
      </tr>
      <tr>
        <th height="92" bgcolor="#FF0000" scope="row">个性签名</th>
        <td colspan="2" bgcolor="#0000FF">
        <label for="textarea"></label>
        <textarea name="note" cols="60" rows="5" id="note"><%=user.getNote() %></textarea></td>
      </tr>
      <tr bgcolor="#FF0000">
        <th colspan="3" scope="row">
        	<input type="submit" name="button" id="button" value="修改">
        </th>
      </tr>
    </table>
  </div>
  
</form>
</body>
</html>