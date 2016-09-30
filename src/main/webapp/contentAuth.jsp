<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Clouder</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
  </head>
    <a class="btn btn-success btn-lg" href="cabinet.jsp" role="button"><c:out value="${contentAuthCabinet}"/></a>
    <a class="btn btn-success btn-lg" href="/login" role="button"><c:out value="${contentAuthExit}"/></a>
</html>
