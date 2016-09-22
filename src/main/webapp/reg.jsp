<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/reg.css">
</head>
    <body>
    <div class="header">
        <jsp:include page="header.jsp"/>
    </div>
    <div class="main">
        <div class="frame">
            <div class="menu">
                <jsp:include page="menu.jsp"/>
            </div>
            <div class="content">
                <form action="/reg" method="POST" accept-charset="ISO-8859-1">
                    <table>
                        <tr>
                            <td width="100px"><c:out value="${regLogin}"/></td>
                            <td width="150px"><input type="text" name="login" placeholder="Login" value="${param.login}" tabindex="1"></td>
                            <td>
                                <c:if test="${param.loginError != ''}">
                                    ${param.loginError}
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td width="100px">e-mail: </td>
                            <td width="150px"><input type="text" name="email" placeholder="Email" value="${param.email}" tabindex="2"></td>
                            <td>
                                <c:if test="${'' != param.emailError}">
                                    ${param.emailError}
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td><c:out value="${regPass}"/>: </td>
                            <td width="150px"><input type="password" name="password" value="${param.pass}" tabindex="3"></td>
                            <td>
                                <c:if test="${'' != param.passError}">
                                    ${param.passError}
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td><c:out value="${regPass2}"/> </td>
                            <td width="150px"><input type="password" name="password2" value="${param.pass2}" tabindex="4"></td>
                            <td>
                                <c:if test="${'' != param.passcError}">
                                    ${param.passcError}
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" tabindex="4"><button tabindex="5"><c:out value="${regButton}"/></button></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <div class="bottom">
        <jsp:include page ="bottom.jsp"/>
    </div>
    </body>
</html>