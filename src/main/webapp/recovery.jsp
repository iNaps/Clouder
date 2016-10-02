<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<!DOCTYPE html>
<html lang="en">
  <head>
    <title><c:out value="${recTitle}"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/recovery.css" rel="stylesheet">
  </head>
  <body>
    <div class="background">
    <div class="brand"><h2><a href="index.jsp">Clouder</a></h2></div>
    <div class="loginform">
      <form class="form-signin" action="/sender" method="POST">
        <table>
            <tr>
                <td class="field" colspan="2"><c:out value="${recText}"/></td>
            </tr>
            <tr>
                <td class="field"><input type="text" name="email" placeholder="e-mail"></td>
                <td><button class="btn btn-success btn-sm btn-block" type="submit"><c:out value="${send}"/></button></td>
            </tr>
        </table>
      </form>
    </div>
    </div>
  </body>
</html>