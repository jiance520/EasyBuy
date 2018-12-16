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
<script type="text/javascript" src="<%=basePath %>scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript">

   $(function(){
       //alert(0);
       $(".delproduct").click(function(){
              var node = $(this) ;
              var vs = node.next().val();// pid
              //alert(1);
              //node.parent().parent().remove();
              var ck = confirm('是否删除！！');
              if(ck){
                $.post('DelShop',{pid:vs},function(data){
                  //alert(data);
                  if(data=='true'){
                     node.parent().parent().remove();
                  }
                }) ;
                // 
              }
          //     
       });
       
       //减
       $(".miu").click(function(){
          var node = $(this).next().find("input");
          var vs = node.val();
              vs = parseInt(vs);
          //alert(vs);
          if(vs < 2){
              alert('数目不能小于2！！');
          }else{
             vs--;
             node.val(vs);
          }
          
       });
       
       //加
       $(".add").click(function(){
          var node = $(this).prev().find("input");
          var vs = node.val();
              vs = parseInt(vs);
          //alert(vs);
             vs++;
             node.val(vs);
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
	您现在的位置：<a href="IndexAction">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="AddOrder" method="post">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<%-- 
				<tr id="product_id_1">
					<td class="thumb"><img src="images/product/0_tiny.gif" /><a href="product-view.jsp">铁三角 Audio-Technica ATH-EQ300M-SV 银色 挂耳式耳机</a></td>
					<td class="price" id="price_id_1">
						<span>￥99.00</span>
						<input type="hidden" value="99" />
					</td>
					<td class="number">
						<dl>
							<dt><input id="number_id_1" type="text" name="number" value="1" /></dt>
							<dd onclick="javascript:void(0)">修改</dd>
						</dl>
					</td>
					<td class="delete"><a href="javascript:void(0)">删除</a></td>
				</tr>
				--%>
				<c:forEach var="p2" items="${plist}">
				<tr id="product_id_1">
					<td class="thumb"><img src="${p2.fileName}" /><a href="OneProduct?pid=${p2.id}">${p2.name}</a></td>
					<td class="price" id="price_id_1">
						<span>￥${p2.price}</span>
						
					</td>
					<td class="number">
						<dl>
						    <dd style="width:10px;" class="miu">-</dd>
							<dt><input id="number_id_1" type="text" name="number" value="1" /></dt>
							<dd style="width:10px;" class="add">+</dd>
						</dl>
					</td>
					<td class="delete"><a href="javascript:void(0)" class="delproduct">删除</a><input type="hidden" value="${p2.id}" name="pid"/></td>
				</tr>
				</c:forEach>
			</table>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
	<script type="text/javascript">
		document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
	</script>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
