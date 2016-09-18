<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                <a href="/login"><button>Выход</button></a>
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