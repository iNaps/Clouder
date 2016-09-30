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
  <body>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <a class="navbar-brand" href="index.jsp">Clouder</a>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Главная</a></li>
            <li><a href="about.jsp">О сервисе</a></li>
            <li><a href="contacts.jsp">Контакты</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="login.jsp">Вход</a></li>
            <li><a href="registration.jsp">Регистрация</a></li>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="/locale?loc=ru" ><img src="images/ru-flag.png" class="img-rounded" alt="Cinque Terre" width="25" height="15"></a></li>
              <li><a href="/locale?loc=en"><img src="images/en-flag.png" class="img-rounded" alt="Cinque Terre" width="25" height="15"></a></li>
            </ul>
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