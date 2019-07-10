<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cn.vo.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-3.4.0.js"></script>
<body background="image/a3bbedd47cac817f3580f3b24b365ceb806f46b9.jpg@1320w_742h.webp.jpg">
<div align="center">
 <%String id=request.getParameter("id");
List<News> newslist=(List<News>)session.getAttribute("newslist");
int i=Integer.parseInt(id);
News n=newslist.get(i);
%>
</div>
<form name="form1" method="post" action="UpdateNewsServlet" id="form1">
  <div align="center">
    <input name="id" type="hidden" id="id" size="60" value="<%=n.getId()%>" >
    <table width="531" border="1" background="image/image_02.jpg">
      <tr>
        <td colspan="2" bgcolor="#66CC00">修改新闻</td>
      </tr>
      <tr>
        <td width="89">新闻标题</td>
        <td width="426"><label for="newsTitle02"></label>
        <input name="title" type="text" id="title" size="60" value="<%=n.getTitle()%>"></td>
      </tr>
      <tr>
        <td>新闻正文</td>
        <td><label for="zw_01"></label>
        <textarea name="content" cols="50" rows="10" id="content"><%=n.getContent() %></textarea></td>
      </tr>
      <tr>
        <td colspan="2">
          <div align="center">
            <input type="button"  value="提交" onclick="checkNews()">
            <input type="reset"   value="重置">
            <input type="button"   value="返回" onclick="re()">
          </div>
        </td>
      </tr>
    </table>
  </div>
</form>
</body>
<script type="text/javascript">
function checkNews(){
	var id=document.getElementById("id").value;
	var title=document.getElementById("title").value;
	var content=document.getElementById("content").value;
	var f=document.getElementById("form1");
	if(title==""){
		alert("标题不能为空");
		return;
	}
	if(content==""){
		alert("请填写内容");
		return;
	}
	/* $.post("UpdateNewsServlet",{"id":id,"title":title,"content":content}, function(data) {
		
		 if(data == "success"){
			 history.go(-1);//返回上一层
			alert("修改成功");
			 
		 }else{
			 alert("修改失败");
		 }
		 }); */
	document.getElementById("form1").submit();
	
}
	
function re(){
	history.go(-1);
}
</script>
</html>