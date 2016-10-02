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
    <div class="background">
    <div class="brand"><h2><a href="index.jsp">Clouder</a></h2></div>
    <div class="loginform">
        <form class="form-group" action="/login" method="POST">
          <table>
            <tr>
              <td class="field"><c:out value="${login}"/></td>
              <td width="200px"><input type="text" name="login" class="form-control login" placeholder="Login"></td>
            </tr>
            <tr>
              <td class="field"><c:out value="${password}"/></td>
              <td width="200px"><input type="password" name="password" class="form-control password" placeholder="Password"></td>
            </tr>
            <tr>
                <td colspan="2" ><button class="btn btn-md btn-success button" type="submit"><c:out value="${signin}"/></button></td>
            </tr>
          </table>
          <table class="table2">
            <tr>
              <td class="recovery"><a href="/recovery.jsp"><c:out value="${loginRecovery}"/></a></td>
              <td><a href="/registration.jsp"><c:out value="${registration}"/></a></td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  </body>
</html>
