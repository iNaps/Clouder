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
    <link href="css/bottom.css" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <a class="navbar-brand" href="index.jsp">Clouder</a>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#"><c:out value="${navbarMain}"/></a></li>
            <li><a href="about.jsp"><c:out value="${navbarAbout}"/></a></li>
            <li><a href="contacts.jsp"><c:out value="${navbarContacts}"/></a></li>
          </ul>
          <jsp:include page="navbar.jsp"/>
        </div>
      </div>
    </nav>
    <div class="content">
      <jsp:include page="/index"/>
    </div>
    <div class="bottom">
      <div class="bottomc">
        <jsp:include page="bottom.jsp"/>
      </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/project/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>