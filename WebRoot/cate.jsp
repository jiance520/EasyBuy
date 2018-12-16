<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=basePath %>scripts/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
	    $(function(){
	         //alert(0);
	         $("[name='parentCate']").change(function(){
	             var vs = $(this).val();
	             //alert(vs);
	             var node = $("[name='childCate']");//子类
	             $.post('AjaxAction',{cid:vs},function(data){
	               //alert(data);
	               // 清除原始数据
	               node.empty();
	               
	               var n1 = "<option value='0'>--请选择--</option>" ;
	               var cn1 = $(n1); // jquery 节点
	               node.append(cn1);
	               //循环 data  , i 下标  ， n 元素 
	               $.each(data,function(i,n){
	                   //alert(n.name);
	                   var n2 = "<option value='"+n.id+"'>"+n.name+"</option>" ;
	                   var cn2 = $(n2);
	                   node.append(cn2);
	               });
	             
	             },'json');
	         
	         });
	    })
	
	</script>
  </head>
  
  <body>
      <form action="javascript:void(0)" method="post">
      <p>
            主类<select name="parentCate">
            <option value="0">--请选择--</option>
            <c:forEach items="${list}" var="pc">
               <option value="${pc.id}">${pc.name}</option>
            </c:forEach>
        </select>  &nbsp;&nbsp;
            子类<select name="childCate">
            <option value="0">--请选择--</option>
        </select>
      </p>
      </form>
  </body>
</html>
