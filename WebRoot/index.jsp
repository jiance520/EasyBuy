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
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="ShopAction" class="shopping">购物车</a>
	<c:if test="${empty sessionScope.userinfo}">
	<a href="login.jsp">登录</a><a href="register.jsp">注册</a>
	</c:if>
	<c:if test="${not empty sessionScope.userinfo}">
	   欢迎 ${sessionScope.userinfo.userName} 的到来
	</c:if>
	<a href="Guestbook">留言</a></div>
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
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
			    <%-- 
				<dt><img src="images/product/0_tiny.gif" /></dt>
				<dd><a href="product-view.jsp">法国德菲丝松露精品巧克力500g/盒</a></dd>
				--%>
				<c:forEach var="p2" items="${hislist}">
				 <dt><img src="${p2.fileName}" style="width:50px;height:50px;"/></dt>
				 <dd><a href="OneProduct?pid=${p2.id}">${p2.name}</a></dd>
				</c:forEach>
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="price-off">
			<h2>今日特价</h2>
			<ul class="product clearfix">
			   <%-- 
				<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/1.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">法国德菲丝松露精品巧克力500g/盒</a></dd>
						<dd class="price">￥108.0</dd>
					</dl>
				</li>
				--%>
				<c:forEach var="p2" items="${tjlist}">
				<li>
					<dl>
						<dt><a href="OneProduct?pid=${p2.id}"><img src="${p2.fileName}" /></a></dt>
						<dd class="title"><a href="OneProduct?pid=${p2.id}">${p2.name}</a></dd>
						<dd class="price">￥${p2.price}</dd>
					</dl>
				</li>
				</c:forEach>
			</ul>
		</div>
		<div class="side">
			<div class="news-list">
				<h4>最新公告</h4>
				<ul>
				   <%--
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
					--%>
					<c:forEach var="n2" items="${sevennews}">
					 <li><a href="news-view.jsp">${n2.title}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul>
				   <%-- 
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
					--%>
					<c:forEach var="n2" items="${allnews}">
					 <li><a href="news-view.jsp">${n2.title}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
		<div class="hot">
			<h2>热卖推荐</h2>
			<ul class="product clearfix">
			   <%-- 
				<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/1.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">法国德菲丝松露精品巧克力500g/盒</a></dd>
						<dd class="price">￥108.0</dd>
					</dl>
				</li>
				--%>
				<c:forEach var="p2" items="${rmlist}">
				<li>
					<dl>
						<dt><a href="OneProduct?pid=${p2.id}"><img src="${p2.fileName}" /></a></dt>
						<dd class="title"><a href="OneProduct?pid=${p2.id}">${p2.name}</a></dd>
						<dd class="price">￥${p2.price}</dd>
					</dl>
				</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
