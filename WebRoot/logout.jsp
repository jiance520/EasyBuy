<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  session.removeAttribute("userinfo");
  response.sendRedirect("IndexAction");
%>
