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


<fmt:message key="signin" bundle="${lang}" var="signin" />
<fmt:message key="registration" bundle="${lang}" var="registration" />
<fmt:message key="cabinet" bundle="${lang}" var="cabinet" />
<fmt:message key="exit" bundle="${lang}" var="exit" />
<fmt:message key="login" bundle="${lang}" var="login" />
<fmt:message key="password" bundle="${lang}" var="password" />
<fmt:message key="send" bundle="${lang}" var="send" />

<fmt:message key="navbar.main" bundle="${lang}" var="navbarMain" />
<fmt:message key="navbar.about" bundle="${lang}" var="navbarAbout" />
<fmt:message key="navbar.contacts" bundle="${lang}" var="navbarContacts" />
<fmt:message key="reg.pass2" bundle="${lang}" var="regPass2" />
<fmt:message key="reg.button" bundle="${lang}" var="regButton" />
<fmt:message key="cabinet.newmail" bundle="${lang}" var="cabinetNewEmail" />
<fmt:message key="cabinet.newpass" bundle="${lang}" var="cabinetNewPassword" />
<fmt:message key="login.recovery" bundle="${lang}" var="loginRecovery" />

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
