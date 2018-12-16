<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'one.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=basePath%>/scripts/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		//不经过servlet取数据
		$(function(){
			var pid = 591;
			$.post('AjaxOne',{pids:pid},function(data){
				alert(data.fileName);
				$('.pimg').attr("src",data.fileName);
			},'json');//text改为JSON才能接收对象，而不是out.print字符
		})
	</script>
  </head>
  
  <body>
    This is my JSP page. <br>
    <p>
    	<img class= "pimg" src=""/>
    </p>
  </body>
</html>
