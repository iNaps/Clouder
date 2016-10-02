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
    <title><c:out value="${registration}"/></title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/registration.css" rel="stylesheet">
  </head>
  <div class="background">
    <div class="brand"><h2><a href="index.jsp">Clouder</a></h2></div>
        <div class="loginform">
          <form class="form-group" action="/registration" method="POST" accept-charset="ISO-8859-1">
                <table>
                  <tr>
                    <td class="field"><c:out value="${login}"/></td>
                    <td><input type="text" name="username" class="form-control field2" placeholder="Login" value="${requestScope.username}" tabindex="1"></td>
                    <td class="res">
                      <n:if exp='${requestScope.loginError}'
                            isTrue='<img src="images/yep.png">'
                            isFalse='<img src="images/nope.png">'
                      />
                    </td>
                  </tr>
                  <tr>
                    <td class="field">e-mail</td>
                    <td><input type="text" name="email" class="form-control field2" placeholder="Email" value="${requestScope.email}" tabindex="2"></td>
                    <td class="res">
                      <n:if exp='${requestScope.emailError}'
                            isTrue='<img src="images/yep.png">'
                            isFalse='<img src="images/nope.png">'
                      />
                    </td>
                  </tr>
                  <tr>
                    <td class="field"><c:out value="${password}"/></td>
                    <td><input type="password" name="password" class="form-control field2" value="${requestScope.password}" tabindex="3"></td>
                    <td class="res">
                      <n:if exp='${requestScope.passError}'
                            isTrue='<img src="images/yep.png">'
                            isFalse='<img src="images/nope.png">'
                      />
                    </td>
                  </tr>
                  <tr>
                    <td class="field"><c:out value="${regPass2}"/></td>
                    <td><input type="password" name="password2" class="form-control field2" value="${requestScope.password2}" tabindex="4"></td>
                    <td class="res">
                      <n:if exp='${requestScope.passcError}'
                            isTrue='<img src="images/yep.png">'
                            isFalse='<img src="images/nope.png">'
                      />
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2"><button class="btn btn-lg btn-success btn-block button" type="submit"><c:out value="${regButton}"/></button></td>
                  </tr>
                </table>
              </form>
        </div>
    </div>
  </div>
  </body>
</html>
