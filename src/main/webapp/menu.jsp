<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<table cellspacing="0">
    <tr>
        <td><a href="index.jsp"><button><c:out value="${menuAbout}"/></button></a></td>
        <td><a href="index.jsp"><button><c:out value="${menuIntro}"/></button></a></td>
        <td><a href="index.jsp"><button><c:out value="${menuHowtouse}"/></button></a></td>
        <td><a href="index.jsp"><button><c:out value="${menuFeedback}"/></button></a></td>
    </tr>
</table>