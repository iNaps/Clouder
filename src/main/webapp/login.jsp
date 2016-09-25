<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/login.css">
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
                <table>
                    <form action="/login" method="POST">
                        <tr>
                            <td width="100px"><c:out value="${loginLogin}"/></td>
                            <td width="150px"><input type="text" name="login" placeholder="Login" tabindex="1"></td>
                            <td rowspan="2"><button tabindex="3"><c:out value="${loginIn}"/></button></td>
                        </tr>
                        <tr>
                            <td><c:out value="${loginPass}"/>: </td>
                            <td tabindex="2"><input type="password" name="password" placeholder="Password" tabindex="2"></td>
                        </tr>
                    </form>
                    <tr>
                        <td><a href="/recovery.jsp"><div class="reclink"><c:out value="${loginRecovery}"/></div></a></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div class="bottom">
        <jsp:include page = "bottom.jsp"/>
    </div>
    </body>
</html>