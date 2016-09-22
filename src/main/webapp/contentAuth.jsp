<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<a href="cabinet.jsp"><button><c:out value="${contentAuthCabinet}"/></button></a>
<a href="/login"><button><c:out value="${contentAuthExit}"/></button></a>