<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                <form action="/reg" method="POST">
                    <table>
                        <tr>
                            <td width="100px">Логин: </td>
                            <td width="150px"><input type="text" name="login" placeholder="Login" tabindex="1"></td>
                            <td><div id="flagLogin"></div></td>
                        </tr>
                        <tr>
                            <td width="100px">e-mail: </td>
                            <td width="150px"><input type="text" name="email" placeholder="Email" tabindex="2"></td>
                            <td><div id="flagEmail"></div></td>
                        </tr>
                        <tr>
                            <td>Пароль: </td>
                            <td width="150px"><input type="password" name="password" tabindex="3"></td>
                            <td><div id="flagPass"></div></td>
                        </tr>
                        <tr>
                            <td>Ещё раз: </td>
                            <td width="150px"><input type="password" name="passwordR" tabindex="4"></td>
                            <td><div id="flagCheckpass"></div></td>
                        </tr>
                        <tr>
                            <td colspan="2" tabindex="4"><button tabindex="5">Регистрация</button></td>
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