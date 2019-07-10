<%@page import="com.cn.vo.User,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.bulu {
	color: #0CF;
}
</style>
</head>
<body background="image/a3bbedd47cac817f3580f3b24b365ceb806f46b9.jpg@1320w_742h.webp.jpg">
<%User user=(User)session.getAttribute("user");%>
<form name="form1" method="post" action="">
  <div align="center">
    <table width="607" border="1">
      <tr bgcolor="#00FFFF">
        <th colspan="3" scope="row">个人信息</th>
      </tr>
      <tr>
        <th width="151" bgcolor="#00FFFF" scope="row">姓名</th>
        <td width="440" colspan="2" bgcolor="#99FF00"><%=user.getUsername() %></td>
      </tr>
      <tr>
        <th bgcolor="#00FFFF" scope="row">密码</th>
        <td colspan="2" bgcolor="#00FF00"><%=user.getPassword() %></td>
      </tr>
      <tr>
        <th bgcolor="#00FFFF" scope="row">权限</th>
        <td colspan="2" bgcolor="#00FF00"><%=user.getType() %>（0：普通用户，1：管理员）</td>
      </tr>
      <tr>
        <th bgcolor="#00FFFF" scope="row">性别</th>
        <td colspan="2" bgcolor="#00FF00"><%=user.getSex() %>     （
        0：男生，1：女生）</td>
      </tr>
      <tr>
        <th bgcolor="#00FFFF" scope="row">职业</th>
        <td colspan="2" bgcolor="#00FF00"><%=user.getProfession()%>（
        0：学生，1：老师，2：工人）</td>
      </tr>
      <tr>
        <th bgcolor="#00FFFF" scope="row">兴趣爱好</th>
        <td colspan="2" bgcolor="#00FF00"><%=user.getFavourite() %>（
        0：电脑网络，1：影视娱乐，2：棋牌娱乐）</td>
      </tr>
      <tr>
        <th height="92" bgcolor="#00FFFF" scope="row">个性签名</th>
        <td colspan="2" bgcolor="#00FF00">
        <%=user.getNote() %></td>
      </tr>
      <tr bgcolor="#00FFFF">
        <th colspan="3" scope="row">
        <input type="button" name="button3" id="button3" value="返回" onclick="fanhui()"></th>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">
function fanhui(){
	history.go(-1);
}
</script>
</body>
</html>