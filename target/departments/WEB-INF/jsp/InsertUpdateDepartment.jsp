<%--
  Created by IntelliJ IDEA.
  User: vchuhai
  Date: 07.04.2020
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Departments</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style type="text/css">
        <%@include file="/css/bootstrap.min.css"%>
    </style>
</head>
<body>
<div class="container">
    <h2 class="w-100 d-flex justify-content-center">Departments Management</h2>
    <h3 class="w-100 d-flex justify-content-center">
        <form action="/departments/departments" method="post">
            <input type="submit" value="List of Departments" class="btn btn-dark"/>
        </form>
    </h3>

    <c:if test="${department != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${department == null}">
        <form action="update" method="post">
            </c:if>

            <h3 class="w-100 d-flex justify-content-center">
                <c:if test="${department.id != null}">
                    Edit Department
                </c:if>
                <c:if test="${department.id == null}">
                    Add New Department
                </c:if>
            </h3>

            <c:if test="${department.id != null}">
                <input type="hidden" name="id" value="<c:out value='${department.id}' />"/>
            </c:if>

            <label for="name">Name:</label>
            <div class="d-flex align-items-center">
                <input type="text" class="form-control" name="name" id="name"
                       value="<c:out value='${department.name}' />"
                />

                <input type="submit" value="Save" class="btn btn-dark"/>
            </div>

        </form>
            <c:if test="${map.name != null}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <c:out value='${map.name}'/>
            </div>
            </c:if>
</div>
</body>
</html>
