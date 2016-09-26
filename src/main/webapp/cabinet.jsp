<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<!DOCTYPE html>
<html>
<head>
    <title>Cabinet</title>
    <link rel="stylesheet" href="css/cabinet.css">
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
                    <tr>
                        <td>Новый e-mail:</td>
                        <form action="/edit" method="POST">
                            <td><input type="text" name="email"></td>
                            <td><input type="submit"></td>
                        </form>
                    </tr>
                    <tr>
                        <td>Новый пароль:</td>
                        <form action="/edit" method="POST">
                            <td><input type="password" name="password"></td>
                            <td><input type="submit"></td>
                        </form>
                    </tr>
                </table>
                <a href="/login"><button><c:out value="${cabinetExit}"/></button></a>
                <form action="/upload" method="POST" enctype="multipart/form-data" accept-charset="ISO-8859-1">
                    <table>
                        <tr>
                            <td><input type="file" name="file" multiple></td>
                            <td><input type="submit" value="Загрузить"></td>
                        </tr>
                    </table>
                </form>
                <jsp:include page="/list"/>
            </div>
        </div>
    </div>
    <div class="bottom">
        <jsp:include page ="bottom.jsp"/>
    </div>
    </body>
</html>