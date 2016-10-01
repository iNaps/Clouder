<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="n" uri="WEB-INF/custom.tld"%>
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
      <h1 class="text-center"><a href="index.jsp">Clouder</a></h1>
      <form class="form-signin" action="/registration" method="POST" accept-charset="ISO-8859-1">
        <table>
          <tr>
            <td width="100px"><c:out value="${login}"/></td>
            <td width="150px"><input type="text" name="username" class="form-control" placeholder="Login" value="${requestScope.username}" tabindex="1"></td>
            <td>
              <n:if exp='${requestScope.loginError}'
                    isTrue='<img src="images/yep.png">'
                    isFalse='<img src="images/nope.png">'
              />
            </td>
          </tr>
          <tr>
            <td width="100px">e-mail: </td>
            <td width="150px"><input type="text" name="email" class="form-control" placeholder="Email" value="${requestScope.email}" tabindex="2"></td>
            <td>
              <n:if exp='${requestScope.emailError}'
                    isTrue='<img src="images/yep.png">'
                    isFalse='<img src="images/nope.png">'
              />
            </td>
          </tr>
          <tr>
            <td><c:out value="${password}"/>: </td>
            <td width="150px"><input type="password" name="password" class="form-control" value="${requestScope.password}" tabindex="3"></td>
            <td>
              <n:if exp='${requestScope.passError}'
                    isTrue='<img src="images/yep.png">'
                    isFalse='<img src="images/nope.png">'
              />
            </td>
          </tr>
          <tr>
            <td><c:out value="${regPass2}"/> </td>
            <td width="150px"><input type="password" name="password2" class="form-control" value="${requestScope.password2}" tabindex="4"></td>
            <td>
              <n:if exp='${requestScope.passcError}'
                    isTrue='<img src="images/yep.png">'
                    isFalse='<img src="images/nope.png">'
              />
            </td>
          </tr>
          <tr>
            <td colspan="2"><button class="btn btn-lg btn-primary btn-block" type="submit"><c:out value="${regButton}"/></button></td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>
