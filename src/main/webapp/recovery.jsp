<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Clouder</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
</head>
    <body>
    <div class="main">
        <div class="frame">
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