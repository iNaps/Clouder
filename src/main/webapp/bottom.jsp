<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="locale.jsp" />

<div class="list1">
    <ul>
        <li>CLOUDER</li>
        <li><a href="index.jsp"><c:out value="${bottomAbout}"/></a></li>
        <li><a href="index.jsp"><c:out value="${bottomIntro}"/></a></li>
        <li><a href="index.jsp"><c:out value="${bottomFaq}"/></a></li>
    </ul>
</div>
<div class="list2">
    <ul>
        <li><c:out value="${bottomApps}"/></li>
        <li><a href="index.jsp"><c:out value="${bottomPcclient}"/></a></li>
        <li><a href="index.jsp"><c:out value="${bottomTelegram}"/></a></li>
        <li><a href="index.jsp"><c:out value="${bottomAndroid}"/></a></li>
        <li><a href="index.jsp"><c:out value="${bottomIos}"/></a></li>
    </ul>
</div>
<div class="list3">
    <ul>
        <li><c:out value="${bottomDocs}"/></li>
        <li><a href="index.jsp"><c:out value="${bottomPrivacy}"/></a></li>
        <li><a href="https://github.com/iNaps/Clouder"><c:out value="${bottomSources}"/></a></li>
    </ul>
</div>
