<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="n" uri="WEB-INF/custom.tld"%>
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
                            <td width="150px"><input type="text" name="username" placeholder="Login" value="${requestScope.username}" tabindex="1"></td>
                            <td>
                                <n:if exp='${requestScope.loginError}'
                                    isTrue='<img src="images/yep.png">'
                                    isFalse='<img src="images/nope.png">'
                                />
                            </td>
                        </tr>
                        <tr>
                            <td width="100px">e-mail: </td>
                            <td width="150px"><input type="text" name="email" placeholder="Email" value="${requestScope.email}" tabindex="2"></td>
                            <td>
                                <n:if exp='${requestScope.emailError}'
                                    isTrue='<img src="images/yep.png">'
                                    isFalse='<img src="images/nope.png">'
                                />
                            </td>
                        </tr>
                        <tr>
                            <td><c:out value="${regPass}"/>: </td>
                            <td width="150px"><input type="password" name="password" value="${requestScope.password}" tabindex="3"></td>
                            <td>
                                <n:if exp='${requestScope.passError}'
                                    isTrue='<img src="images/yep.png">'
                                    isFalse='<img src="images/nope.png">'
                                />
                            </td>
                        </tr>
                        <tr>
                            <td><c:out value="${regPass2}"/> </td>
                            <td width="150px"><input type="password" name="password2" value="${requestScope.password2}" tabindex="4"></td>
                            <td>
                                <n:if exp='${requestScope.passcError}'
                                    isTrue='<img src="images/yep.png">'
                                    isFalse='<img src="images/nope.png">'
                                />
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