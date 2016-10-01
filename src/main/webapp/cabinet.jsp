<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<!DOCTYPE html>
<html>
<head>
    <title>Cabinet</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Clouder</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/cabinet.css" rel="stylesheet">
</head>
    <body>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <a class="navbar-brand" href="index.jsp">Clouder</a>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#"><c:out value="${navbarMain}"/></a></li>
            <li><a href="about.jsp"><c:out value="${navbarAbout}"/></a></li>
            <li><a href="contacts.jsp"><c:out value="${navbarContacts}"/></a></li>
          </ul>
          <jsp:include page="navbar.jsp"/>
        </div>
      </div>
    </nav>
    <div class="main">
        <div class="frame">
            <div class="content text-center">
                <table>
                    <tr>
                        <td><c:out value="${cabinetNewEmail}"/></td>
                        <form action="/edit" method="POST">
                            <td><input type="text" name="email"></td>
                            <td><input type="submit"></td>
                        </form>
                    </tr>
                    <tr>
                        <td><c:out value="${cabinetNewPassword}"/></td>
                        <form action="/edit" method="POST">
                            <td><input type="password" name="password"></td>
                            <td><input type="submit"></td>
                        </form>
                    </tr>
                </table>
                <a href="/login"><button><c:out value="${exit}"/></button></a>
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
    <div class="bottom text-center">
        <a class="btn btn-success btn-lg" href="registration.jsp" role="button">Кнопка</a>
    </div>
    </body>
</html>