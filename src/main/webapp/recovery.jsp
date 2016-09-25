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
                <form action="/sender" method="POST">
                    <table>
                        <tr>
                            <td><input type="text" name="email" placeholder="e-mail"></td>
                            <td><button type="submit"><c:out value="${recoveryButton}"/></button></td>
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