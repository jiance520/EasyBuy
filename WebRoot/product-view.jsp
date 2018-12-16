<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="<%=basePath%>scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript">
    
    $(function(){
     
       //alert(0);
       $(":button").click(function(){
           //alert(1);
           window.location.href = "AddShop?pid=${pone.id}" ;
       });
    })
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="ShopAction" class="shopping">购物车</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="#">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="IndexAction">易买网</a> &gt; <a href="product-list.jsp">${parentCate.name}</a> &gt; ${childCate.name}
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
			  <%-- 
				<dt>图书音像</dt>
				<dd><a href="product-list.jsp">图书</a></dd>
				--%>
				<c:forEach var="pc" items="${allcate}">
				  <dt>${pc.name}</dt>
				  <c:set var="clist" value="${pc.clist}"></c:set>
				  <c:forEach var="cc" items="${clist}">
				    <dd><a href="product-list.jsp">${cc.name}</a></dd>
				  </c:forEach>
				</c:forEach>
			</dl>
		</div>
	</div>
	<div id="product" class="main">
		<h1>${pone.name}</h1>
		<div class="infos">
			<div class="thumb"><img src="${pone.fileName}" /></div>
			<div class="buy">
				<p>商城价：<span class="price">￥${pone.price}</span></p>
				<c:if test="${pone.stock > 0}">
				 <p>库　存：${pone.stock}</p>
				 <div class="button"><input type="button" name="button" value="" /></div>
			    </c:if>
			    <c:if test="${pone.stock <= 0}">
			      <p>库　存：没货，无法购买</p>
			    </c:if>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				${pone.description}
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
