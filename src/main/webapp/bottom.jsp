<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<table cellspacing="1">
    <tr>
        <td>
            <p><div class="bottomTdDivCLouder">CLOUDER</div></p>
            <p><a href="index.jsp"><c:out value="${bottomAbout}"/></a></p>
            <p><a href="index.jsp"><c:out value="${bottomIntro}"/></a></p>
            <p><a href="index.jsp"><c:out value="${bottomFaq}"/></a></p>
        </td>
        <td>
            <p><div class="bottomTdDiv"><c:out value="${bottomApps}"/></div></p>
            <p><a href="index.jsp"><c:out value="${bottomPcclient}"/></a></p>
            <p><a href="index.jsp"><c:out value="${bottomTelegram}"/></a></p>
            <p><a href="index.jsp"><c:out value="${bottomAndroid}"/></a></p>
            <p><a href="index.jsp"><c:out value="${bottomIos}"/></a></p>
        </td>
        <td>
            <p><div class="bottomTdDiv"><c:out value="${bottomDocs}"/></div></p>
            <p><a href="index.jsp"><c:out value="${bottomPrivacy}"/></a></p>
            <p><a href="index.jsp"><c:out value="${bottomSources}"/></a></p>
        </td>
    </tr>
</table>