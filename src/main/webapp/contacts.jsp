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
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <a class="navbar-brand" href="index.jsp">Clouder</a>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="index.jsp">Главная</a></li>
            <li><a href="about.jsp">О сервисе</a></li>
            <li class="active"><a href="#">Контакты</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="login.html">Вход</a></li>
            <li><a href="registration.jsp">Регистрация</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="content">
      <jsp:include page="/index"/>
    </div>
    <div class="bottom">
      <a class="btn btn-success btn-lg" href="registration.jsp" role="button">Кнопка</a>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/project/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>