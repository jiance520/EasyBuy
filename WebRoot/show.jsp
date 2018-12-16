<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		*{
			margin:0px;
			padding:0px;
		}
		ul{
			list-style-type: none;
			display:flex;/*弹性布局，html5里面的*/
		}
		li{
			width:150px;
			text-align: center;
			border:1px solid red;
		}
		#main{
			border:1px dashed blue; 
		}
	</style>
	<script type="text/javascript" src="<%=basePath%>/scripts/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		//不经过servlet取数据
		$(function(){
			$("li").mouseover(function(){
				var node = $(this).find("input");
				var ids = node.val();
				$.post("AjaxShow",{pids:ids},function(data){
					//alert(data);
					//先清空
					var mainnode = $("#main");
					mainnode.html('');
					//循环
					$.each(data,function(i,n){
						//alert(n.fileName);//n是data的子成员
						var cnode = "<p><img src='"+n.fileName+"'/></p>";
						conde = $(cnode);//把字符串变成jquery节点
						mainnode.append(cnode);//加入main标签子节点
					});
				},'json');
			});
		});
	</script>
  </head>
  
  <body>
    This is my JSP page. <br>
    <ul>
    	<li>家用电器<input type="hidden" value="628"/></li>
    	<li>少儿图书<input type="hidden" value="546"/></li>
    </ul>
    <div id="main">
    	&nbsp;
    </div>
  </body>
</html>
