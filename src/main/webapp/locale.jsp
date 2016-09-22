<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${sessionScope.language == 'en'}">
    <fmt:setBundle basename="set_en" var="lang"/>
</c:if>

<c:if test="${sessionScope.language == 'ru'}">
    <fmt:setBundle basename="set_ru" var="lang"/>
</c:if>

<c:if test="${sessionScope.language == 'default'}">
    <fmt:setBundle basename="set_ru" var="lang"/>
</c:if>

<c:if test="${sessionScope.language == null}">
    <fmt:setBundle basename="set_en" var="lang"/>
</c:if>

<fmt:message key="content.auth.cabinet" bundle="${lang}" var="contentAuthCabinet" />
<fmt:message key="content.auth.exit" bundle="${lang}" var="contentAuthExit" />
<fmt:message key="content.unauth.login" bundle="${lang}" var="contentUnauthLogin" />
<fmt:message key="content.unauth.registration" bundle="${lang}" var="contentUnauthRegistration" />

<fmt:message key="header.auth.cabinet" bundle="${lang}" var="headerAuthCabinet" />
<fmt:message key="header.auth.exit" bundle="${lang}" var="headerAuthExit" />

<fmt:message key="header.unauth.login" bundle="${lang}" var="headerUnauthLogin" />

<fmt:message key="menu.about" bundle="${lang}" var="menuAbout" />
<fmt:message key="menu.intro" bundle="${lang}" var="menuIntro" />
<fmt:message key="menu.howtouse" bundle="${lang}" var="menuHowtouse" />
<fmt:message key="menu.feedback" bundle="${lang}" var="menuFeedback" />

<fmt:message key="reg.login" bundle="${lang}" var="regLogin" />
<fmt:message key="reg.pass" bundle="${lang}" var="regPass" />
<fmt:message key="reg.pass2" bundle="${lang}" var="regPass2" />
<fmt:message key="reg.button" bundle="${lang}" var="regButton" />

<fmt:message key="login.login" bundle="${lang}" var="loginLogin" />
<fmt:message key="login.pass" bundle="${lang}" var="loginPass" />
<fmt:message key="login.in" bundle="${lang}" var="loginIn" />

<fmt:message key="cabinet.exit" bundle="${lang}" var="cabinetExit" />

<fmt:message key="bottom.about" bundle="${lang}" var="bottomAbout" />
<fmt:message key="bottom.intro" bundle="${lang}" var="bottomIntro" />
<fmt:message key="bottom.faq" bundle="${lang}" var="bottomFaq" />

<fmt:message key="bottom.apps" bundle="${lang}" var="bottomApps" />
<fmt:message key="bottom.pcclient" bundle="${lang}" var="bottomPcclient" />
<fmt:message key="bottom.telegram" bundle="${lang}" var="bottomTelegram" />
<fmt:message key="bottom.android" bundle="${lang}" var="bottomAndroid" />
<fmt:message key="bottom.ios" bundle="${lang}" var="bottomIos" />

<fmt:message key="bottom.docs" bundle="${lang}" var="bottomDocs" />
<fmt:message key="bottom.privacy" bundle="${lang}" var="bottomPrivacy" />
<fmt:message key="bottom.source" bundle="${lang}" var="bottomSources" />
