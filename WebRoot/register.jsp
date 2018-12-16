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
<script type="text/javascript" src="<%=basePath %>scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/adddate.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript">
   $(function(){
       //alert(0);
       $("#veryCode").click(function(){
            //var ss = $(this).attr("src");
            //alert(ss);
             var vs = "/EasyBuy/ImageAction?times="+new Date();
             $(this).attr("src",vs);
       });
       
       //
       $("[name='userId']").blur(function(){
            var vs = $(this).val();
            var node = $(this).next();//span
            //alert(vs);
            // 发送 ajax 请求 
            $.post('CheckAction',{uid:vs},function(data){ 
                  // 回调函数 
                  //alert(data);
                  if(data == 'true'){
                     node.html('用户编码已经存在！！！');
                     node.addClass('error');
                  }else{
                     node.html('');
                     node.removeClass();
                  }
                 
            });
       });
       
   })

</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="#" class="shopping">购物车</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a></div>
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
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎注册易买网</h1>
			<ul class="steps clearfix">
				<li class="current"><em></em>填写注册信息</li>
				<li class="last"><em></em>注册成功</li>
			</ul>
			<form id="regForm" method="post" action="RegisterAction" >
			    <div>
			      <c:if test="${not empty regerror}">
			         ${regerror}
			      </c:if>
			    </div>
				<table>
				    <tr>
						<td class="field">用户编号：</td>
						<td><input class="text" type="text" name="userId" /><span></span></td>
					</tr>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="text" type="text" name=userName /><span></span></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password" id="password" name="password" /><span></span></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><input class="text" type="password" name="rePassWord" /><span></span></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td><input type="radio" name="sex" value="T" checked="checked"/>&nbsp;男
						    <input type="radio" name="sex" value="F"/>&nbsp;女
						<span></span></td>
					</tr>
					<tr>
						<td class="field">生日：</td>
						<td><input type="text" name="birthday" readonly="readonly" onclick="SelectDate(this,'yyyy-MM-dd')"/>
						<span></span></td>
					</tr>
					<tr>
						<td class="field">身份证：</td>
						<td><input class="text" type="text" name="idCode" /><span></span></td>
					</tr>
					<tr>
						<td class="field">邮箱：</td>
						<td><input class="text" type="text" name="email" /><span></span></td>
					</tr>
					<tr>
						<td class="field">手机：</td>
						<td><input class="text" type="text" name="mobile" /><span></span></td>
					</tr>
					<tr>
						<td class="field">地址：</td>
						<td><textarea name="address" cols="30" rows="5"></textarea><span></span></td>
					</tr>
					<tr>
						<td class="field">验证码：</td>
						<td><input class="text verycode" type="text" name="veryCode" /><img id="veryCode" src="/EasyBuy/ImageAction" />
						<c:if test="${empty veryerror}">
						<span></span>
						</c:if>
						<c:if test="${not empty veryerror}">
						<span class="error">${veryerror}</span>
						</c:if>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="提交注册" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
