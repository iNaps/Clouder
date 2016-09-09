<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                <form action="/login" method="POST">
                    <table>
                        <tr>
                            <td width="100px">Логин: </td>
                            <td width="150px"><input type="text" name="login" placeholder="Login" tabindex="1"></td>
                            <td rowspan="2"><button tabindex="3">Вход</button></td>
                        </tr>
                        <tr>
                            <td>Пароль: </td>
                            <td tabindex="2"><input type="password" name="password" placeholder="Password" tabindex="2"></td>
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