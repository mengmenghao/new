<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cn.vo.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-3.4.0.js"></script>
<body>
<form name="form1" method="post" action="AddNewsServlet" id="f">
  <div align="center">
    <table width="651" border="1" background="image/a3bbedd47cac817f3580f3b24b365ceb806f46b9.jpg@1320w_742h.webp.jpg">
      <tr>
        <td colspan="2" align="center" valign="middle" bgcolor="#0099FF">发布新闻</td>
      </tr>
      <tr>
        <td width="104" align="center" valign="middle">新闻标题</td>
        <td width="531"><label for="newsTitle02"></label>
        <input name="title" type="text" id="title" size="60"></td>
      </tr>
      <tr>
        <td>新闻正文</td>
        <td><label for="zw_01"></label>
        <textarea name="content" cols="60" rows="10" id="content"></textarea></td>
      </tr>
      <tr>
        <td colspan="2"><div align="center">
          <input type="submit"  value="提交" onclick="con()">
          <input type="reset"   value="重置">
          <input type="button" name="button" id="button" value="返回" onclick="re()">
        </div></td>
      </tr>
    </table>
  </div>
</form>
</body>
<script type="text/javascript">
function con(){
	var title=document.getElementById("title").value;
	var content=document.getElementById("content").value;
	if(title==""){
		alert("标题不能为空");
	}else if(content==""){
		alert("请填写内容");
	}else{
		 document.getElementById("f").submit(); 
	  }
}
/* function panduan(){
	var title=document.getElementById("title").value;
	var content=document.getElementById("content").value;
	 $.post("AddNewsServlet",{"title":title,"content":content}, function(data) {
			
		 if(data == "success"){
			 history.go(-1);//返回上一层
			alert("添加成功");
			 
		 }else{
			 alert("添加失败");
		 }
		 }); 
}
function con(){
	cn();
	panduan();
	document.getElementById("f").submit;
} */
function re(){
	history.go(-1);
}
</script>
</html>