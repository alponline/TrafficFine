<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
     <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css' />">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="trafficFinneApp" class="ng-cloak">

      teste de Spring MVC!!
      

      <script src="<c:url value='/static/angular-1.5.0/angular.js' />"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js//controller/traffic_fine_controller.js' />"></script>
      <script src="<c:url value='/static/js/service/traffic_fine_service.js' />"></script>
      <script src="<c:url value='/static/js/jquery-2.2.1.min.js' />"></script>
  </body>
</html>