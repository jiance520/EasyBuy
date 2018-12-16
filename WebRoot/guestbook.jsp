<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="include.jsp" %>
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
	<div class="help"><a href="#" class="shopping">购物车</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a><a href="guestbook.jsp">留言</a></div>
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
	您现在的位置：<a href="IndexAction">易买网</a> &gt; 在线留言
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
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
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
			   <%-- 
				<li>
					<dl>
						<dt>那个什么衣服贵吗</dt>
						<dd class="author">网友：张三丰 <span class="timer">2010:10:10 20:00:01</span></dd>
						<dd>不贵</dd>
					</dl>
				</li>
				--%>
			    <c:forEach var="cm" items="${list}">
			     <li>
					<dl>
						<dt><c:out value="${cm.content}"/></dt>
						<dd class="author">网友：${cm.name} <span class="timer">${cm.ctime}</span></dd>
						<dd>${cm.reply}</dd>
					</dl>
				 </li>
			    </c:forEach>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="Guestbook?pno=${pagenum-1}">上一页</a></li>
					
					<c:if test="${pagenum <= pagecount}">
					 <li class="current">${pagenum}</li>
					</c:if>
					
					<c:if test="${pagenum+1 <= pagecount}">
					 <li><a href="Guestbook?pno=${pagenum+1}">${pagenum+1}</a></li>
					</c:if>
					
					<li><a href="Guestbook?pno=${pagenum+1}">下一页</a></li>
					<li>
					   第 ${pagenum}页 &nbsp;/ &nbsp;共${pagecount}页
					</li>
				</ul>
			</div>
			<div id="reply-box">
				<form action="Addguest" method="post">
					<table>
					   <%-- 
						<tr>
							<td class="field">昵称：</td>
							<td><input class="text" type="text" name="guestName" /></td>
						</tr>
						<tr>
							<td class="field">留言标题：</td>
							<td><input class="text" type="text" name="guestTitle" /></td>
						</tr>
						--%>
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="guestContent"></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form>
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
