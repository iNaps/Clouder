<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Signin Template for Bootstrap</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
      <h1 class="text-center"><a href="index.html">Clouder</a></h1>
      <form class="form-signin" action="/login" method="POST">
        <table>
          <tr>
            <td width="100px"><c:out value="${loginLogin}"/></td>
            <td width="150px"><input type="text" name="login" class="form-control" placeholder="Login" tabindex="1"></td>
          </tr>
          <tr>
            <td><c:out value="${loginPass}"/>: </td>
            <td tabindex="2"><input type="password" name="password" class="form-control" placeholder="Password" tabindex="2"></td>
          </tr>
          <tr>
            <td colspan="2"><a href="/recovery.jsp"><div class="reclink"><c:out value="${loginRecovery}"/></div></a></td>
          </tr>
        </table>
        <div class="checkbox">
          <label><input type="checkbox" value="remember-me">Запомнить</label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><c:out value="${loginIn}"/></button>
      </form>
    </div>
  </body>
</html>
