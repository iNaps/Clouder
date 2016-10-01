<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<!DOCTYPE html>
<html lang="en">
  <head>
    <title><c:out value="${loginRecovery}"/></title>
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
      <h1 class="text-center"><a href="index.jsp">Clouder</a></h1>
      <form class="form-signin" action="/sender" method="POST">
        <table>
          <tr>
            <td><input type="text" name="email" placeholder="e-mail"></td>
            <td><button class="btn btn-success btn-lg" type="submit"><c:out value="${signin}"/></button></td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>