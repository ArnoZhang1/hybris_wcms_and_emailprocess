<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--
createforhtahtraining
--%>
<template:newpage pageTitle="${pageTitle}">

	<%--  面包屑组件BreadcrumbComponent 位于页面模板上 --%>
	<cms:pageSlot position="Breadcrumb" var="comp" element="div">
		<cms:component component="${comp}" element="div" />
	</cms:pageSlot>

	<%--     促销商品组件 PromotionProductsComponent （这儿用的是客制化组件） 位于页面上  --%>
	<cms:pageSlot position="PromotionProducts" var="comp" element="div"   >
		<cms:component component="${comp}" element="div" />
	</cms:pageSlot>

	<%-- 没有jsp的组件  SampleTrainingComponent--%>
	<cms:pageSlot position="SampleTraining" var="comp" element="div">
		没有jsp的sampleTraining组件：
		</br>
		组件Uid：
		</br>
		<strong>${comp.uid}</strong>
		</br>
	组件上维护的链接：
		</br>

		<strong>
				${comp.linkUrl}
		</strong>
	</cms:pageSlot>
</template:newpage>