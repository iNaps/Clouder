<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
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
                <form action="/registration" method="POST" accept-charset="ISO-8859-1">
                    <table>
                        <tr>
                            <td width="100px"><c:out value="${regLogin}"/></td>
                            <td width="150px"><input type="text" name="login" placeholder="Login" value="${requestScope.login}" tabindex="1"></td>
                            <td>
                                <c:if test="${requestScope.loginError == 'true'}">
                                    <img src="images/yep.png">
                                </c:if>
                                <c:if test="${requestScope.loginError == 'false'}">
                                    <img src="images/nope.png">
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td width="100px">e-mail: </td>
                            <td width="150px"><input type="text" name="email" placeholder="Email" value="${requestScope.email}" tabindex="2"></td>
                            <td>
                                <c:if test="${requestScope.emailError == 'true'}">
                                    <img src="images/yep.png">
                                </c:if>
                                <c:if test="${requestScope.emailError == 'false'}">
                                    <img src="images/nope.png">
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td><c:out value="${regPass}"/>: </td>
                            <td width="150px"><input type="password" name="password" value="${requestScope.pass}" tabindex="3"></td>
                            <td>
                                <c:if test="${requestScope.passError == 'true'}">
                                    <img src="images/yep.png">
                                </c:if>
                                <c:if test="${requestScope.passError == 'false'}">
                                    <img src="images/nope.png">
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td><c:out value="${regPass2}"/> </td>
                            <td width="150px"><input type="password" name="password2" value="${requestScope.pass2}" tabindex="4"></td>
                            <td>
                                <c:if test="${requestScope.passcError == 'true'}">
                                    <img src="images/yep.png">
                                </c:if>
                                <c:if test="${requestScope.passcError == 'false'}">
                                    <img src="images/nope.png">
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