<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="breadcrumb"
		   tagdir="/WEB-INF/tags/responsive/nav/breadcrumb"%>
<%--
htahtraining start
--%>
面包屑组件

${breadcumbcomponentTest}
<%--
htahtraining end
--%>
</br>
<c:if test="${fn:length(breadcrumbs) > 0}">
	<div class="breadcrumb-section">
		<breadcrumb:breadcrumb breadcrumbs="${breadcrumbs}" />
	</div>
</c:if>