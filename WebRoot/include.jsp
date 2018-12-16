<%@ page language="java" import="entity.*" pageEncoding="UTF-8"%>
<%
     Object uobj = session.getAttribute("userinfo");
     if(uobj == null){
         // response.sendRedirect("/EasyBuy/login.jsp");
     }
%>
