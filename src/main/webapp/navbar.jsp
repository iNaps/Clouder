<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="n" uri="WEB-INF/custom.tld"%>
<jsp:directive.include file="locale.jsp" />

<ul class="nav navbar-nav navbar-right">
    <c:choose>
        <c:when test="${sessionScope.user == null}">
            <li><a href="login.jsp"><c:out value="${signin}"/></a></li>
        </c:when>
        <c:otherwise>
            <li><a href="cabinet.jsp"><c:out value="${cabinet}"/></a></li><li><a href="/login"><c:out value="${exit}"/></a></li>
        </c:otherwise>
    </c:choose>

  <ul class="nav navbar-nav navbar-right">
    <li><a href="/locale?loc=ru" ><img src="images/ru-flag.png" class="img-rounded" width="25" height="15"></a></li>
    <li><a href="/locale?loc=en"><img src="images/en-flag.png" class="img-rounded" width="25" height="15"></a></li>
  </ul>
</ul>