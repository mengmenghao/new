<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.cn.vo.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.cloor {
	color:#FF9966;
}

#updateuser{
	background-color: white;
	width: 303px;
	height: 240px;
	margin: auto;
	position: absolute;
	z-index: 2;
	left: 49px;
	top: 42px;
	border: #000 thick solid;
	padding-top: 20px;
	padding-left: 50px;
}
a{ text-decoration: none; color:blue;}
a:hover{text-decoration:underline;}

</style>
</head>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<body background="image/a3bbedd47cac817f3580f3b24b365ceb806f46b9.jpg@1320w_742h.webp.jpg">
<%List<User> userlist=(List<User>)session.getAttribute("userlist");
	//UserService  userService=new UserService();
	//User u=(User)session.getAttribute("user");
%>
<form name="form1" method="post" action="QueryUserServlet">
  <p align="center">
    <input type="text" id="querynews" name="query" width="250px" height="30px"> 
    <input type="checkbox" name="checkbox" id="checkbox" value="0">
    <label for="checkbox" class="z">
    用户名
    </label>
    <input type="checkbox" name="checkbox" id="checkbox2" value="1">
    <label for="checkbox2" class="z2">
    性别
    </label>
	<input type="checkbox" name="checkbox" id="checkbox3" value="2">
	<label for="checkbox3" class="z3">
    职业
    </label>
<input type="submit" value="查询" class="bu" onclick="QueryUser()">
  </p>
<div align="center">
    <table  border="1" >
      <tr bgcolor="#FFFFFF" class="bt">
        <td width="103" align="center" valign="middle" class="cloor">序号</td>
        <td width="103" align="center" class="cloor">姓名</td>
       <!--  <td width="203" align="center" class="cloor">密码</td> -->
        <td width="93" align="center" class="cloor">性别</td>
        <td width="103" align="center" class="cloor">职业</td>
        <!-- <td width="103" align="center" class="cloor">兴趣爱好</td>
        <td width="103" align="center" class="cloor">个性签名</td> -->
        <td width="103" align="center" class="cloor">权限</td>
        <td width="103" align="center" class="cloor">操作</td>
      </tr>
       <%if(userlist!=null){
    	 for(int i=0;i<userlist.size();i++){
    %>
      <tr align="center" valign="middle">
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=i+1 %></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=userlist.get(i).getUsername()%></td>
        <%-- <td width="103" bgcolor="#FFFFFF" class="cloor"><%=userlist.get(i).getPassword()%></td> --%>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=userlist.get(i).getSex()%></td>
		<td width="103" bgcolor="#FFFFFF" class="cloor"><%=userlist.get(i).getProfession() %></td>
<%--          <td width="103" bgcolor="#FFFFFF" class="cloor"><%=userlist.get(i).getFavourite() %></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=userlist.get(i).getNote()%></td> --%>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=userlist.get(i).getType()%></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor">
          <a href="#" onclick="updateUser(this)">修改</a>
          <a href="DeleteUserServlet?id=<%=userlist.get(i).getId()%>">删除</a>
          <a href="ViewDetailsUserServlet?id=<%=userlist.get(i).getId() %>">查看详情</a>
          <%if(userlist.get(i).getType().equals("0")||userlist.get(i).getType().equals("1")){%>
      			<a href="BanUserServlet?id=<%=userlist.get(i).getId()%>">冻结</a>
		  <%} else{ %>
      			<a href="SetUserServlet?id=<%=userlist.get(i).getId()%>">解冻</a>
    		 <%
     		 }
    	  } 
    	 } 
    	 %> 
    </table>
 </div>
 </form> 
<div id="updateuser">
修改用户信息
<hr>
<form action="UpdateUserServlet" method="post">
<input type="hidden"  id="id" name="id"/>
用户名：<input type="text"  id="username" name="username"/><br>
密码： <input type="text" id="password" name="password"><br>
性别：<input type="radio" name="sex" value="0">男
<input type="radio" name="sex" value="1">女<br>
类型：<select id="type" name="type">
<option value="2">冻结用户</option>
<option value="1">管理员</option>
<option value="0">普通用户</option>
</select><br>
<input name="提交" type="submit" value="修改">
<input type="reset" value="重置">
<input type="button" onclick="close_div()" value="关闭">
</form>
</div>
<script type="text/javascript">
$("#updateuser").hide();//隐藏updateuser的div

function updateUser(el){
	var node = el.parentNode.parentNode;//获取当前行
	var a=node.children[1].innerHTML;//获取用户名	
	$.post("GetUserServlet",{"user":a},function(data){
		$("#id").val(data.id);
		$("#updateuser").show();//显示被影藏的div
		$("#username").val(data.username);//将id为username的文本框value属性赋值
		$("#password").val(data.password);
		if(data.sex=='0'){
			$('input:radio[name=sex]:nth(0)').attr('checked',true);//将name为sex的单选按钮的第0个，添加checked属性并赋值为true（相当于被选中）
		}else{
			$('input:radio[name=sex]:nth(1)').attr('checked',true);
		}
		
	   if(data.type=='0'){//0是普通用户
		   $("#type").val("0");//将属性value属性值为0的选中
	   }else if(data.type=='1'){
		   $("#type").val("1");
	   }else if(data.type=='2'){
		   $("#type").val("2");
	   }
	});
}
function close_div(){
	$("#updateuser").hide();
}

</script>
</body>
</html>