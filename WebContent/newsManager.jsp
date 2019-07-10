<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.cn.vo.News,com.cn.vo.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.cloor {
	color: #FF0000;
}
#button {
	font-weight: bold;
	background-color: #0FF;
	height:30px;
}
.bt {
	font-family: "华文琥珀";
}
a{
	text-decoration:none;
	color:#333;
}
.z {
	color: #F00;
}
.z2 {
	color: #F00;
}
.z3 {
	color: #F00;
}
.bu{
	font-weight: bold;
	background-color: #0FF;
	width:50px;
	height:30px;
	}
</style>
</head>
<script type="text/javascript" src="js/jquery-3.4.0.js"></script>
<body background="image/a3bbedd47cac817f3580f3b24b365ceb806f46b9.jpg@1320w_742h.webp.jpg">
<%List<News> newslist=(List<News>)session.getAttribute("newslist");
	//UserService  userService=new UserService();
	User u=(User)session.getAttribute("user");
%>
<form name="form1" method="post">
  <p align="center">
  	<strong>
   	 <input type="button" name="button" id="button" onclick="addNews()" value="添加新闻">
  	</strong> 
    <input type="text" id="querynews" name="query" width="250px" height="30px"> 
    <input type="checkbox" name="checkbox" id="checkbox" value="0">
    <label for="checkbox" class="z">
    新闻标题
    </label>
    <input type="checkbox" name="checkbox" id="checkbox2" value="1">
    <label for="checkbox2" class="z2">
    新闻内容
    </label>
	<input type="checkbox" name="checkbox" id="checkbox3" value="2">
	<label for="checkbox3" class="z3">
    发布人
    </label>

<input type="submit" value="查询" class="bu" onclick="QueryNews()">
  </p>
  <div align="center">
    <table  border="1" >
      <tr bgcolor="#FFFFFF" class="bt">
        <td width="103" align="center" valign="middle" class="cloor">序号</td>
        <td width="103" class="cloor">新闻标题</td>
        <td width="203" align="center" class="cloor">新闻正文</td>
        <td width="93" align="center" class="cloor">发布人</td>
        <td width="103" align="center" class="cloor">发布时间</td>
        <td width="103" align="center" class="cloor">操作</td>
      </tr>
      <%if(newslist!=null){
    	 for(int i=0;i<newslist.size();i++){
    %>
      <tr align="center" valign="middle">
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=i+1 %></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=newslist.get(i).getTitle() %></td>
        <td width="203" bgcolor="#FFFFFF" class="cloor"><%=newslist.get(i).getContent()%></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=newslist.get(i).getUsername() %></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=newslist.get(i).getPubtime()%></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor">
        <%if(u.getType().equals("1")||u.getUsername().equals(newslist.get(i).getUsername())){ %>
          <a href="updateNews.jsp?id=<%=i%>">修改</a>
          <a href="DeleteNewsServlet?id=<%=newslist.get(i).getId()%>">删除</a>
          <a href="ViewDetailsServlet?id=<%=newslist.get(i).getId() %>">查看详情</a>
          <%}else{ %>
          <a href="ViewDetailsServlet?id=<%=newslist.get(i).getId() %>">查看详情</a>
          <%} %></td>
      </tr>
      <% }
    	 } 
    	 %>
    </table>
  </div>
</form>
<script type="text/javascript">
function addNews(){
	window.location.href="addNews.jsp";
}
function QueryNews(){
	form1.action="QueryNewsServlet";
	form1.submit();
}
</script>
</body>
</html>
