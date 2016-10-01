<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<!DOCTYPE html>
<html lang="en">
  <head>
    <title><c:out value="${signin}"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
      <h1 class="text-center"><a href="index.jsp">Clouder</a></h1>
      <form class="form-signin" action="/login" method="POST">
        <table>
          <tr>
            <td width="100px"><c:out value="${login}"/>:</td>
            <td width="200px"><input type="text" name="login" class="form-control" placeholder="Login"></td>
          </tr>
          <tr>
            <td width="100px"><c:out value="${password}"/>:</td>
            <td width="200px"><input type="password" name="password" class="form-control" placeholder="Password"></td>
          </tr>
          <tr>
            <td colspan="2" class="text-center"><a href="/recovery.jsp"><c:out value="${loginRecovery}"/></a></td>
          </tr>
        </table>
        <button class="btn btn-lg btn-success btn-block" type="submit"><c:out value="${signin}"/></button>
      </form>
    </div>
  </body>
</html>
