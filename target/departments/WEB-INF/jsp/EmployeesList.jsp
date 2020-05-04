<%--
  Created by IntelliJ IDEA.
  User: vchuhai
  Date: 08.04.2020
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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

    <h3 class="w-100 d-flex flex-column">
        <form action="/departments/departments" method="post" class="d-flex justify-content-center">
            <input type="submit" value="List of Departments" class="btn btn-dark"/>
        </form>
        <form action="employees/edit" class="d-flex justify-content-center">
            <input type="hidden" name="departmentId" value="${departmentId}">
            <input type="submit" value="Add Employee" class="btn btn-secondary"/>
        </form>
    </h3>

    <table class="table">
        <h3 class="text-muted">List of Employees</h3>
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Email</th>
            <th>Date of Recruitment</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach  var="employee" items="${employees}">
            <tr>
                <th scope="row"><c:out value="${employee.id}" /></th>
                <td><c:out value="${employee.email}" /></td>
                <td><c:out value="${employee.recruitmentDate}" /></td>
                <td><c:out value="${employee.name}" /></td>
                <td><c:out value="${employee.salary}" /></td>
                <td class="d-flex align-items-center">
                    <form action="employees/edit" method="post">
                        <input type="hidden" name="id" value="${employee.id}">
                        <input type="hidden" name="departmentId" value="${departmentId}">
                        <input type="submit" value="Edit" class="btn btn-info"/>
                    </form>
                    <form action="employees/delete" method="post">
                        <input type="hidden" name="id" value="${employee.id}">
                        <input type="hidden" name="departmentId" value="${departmentId}">
                        <input type="submit" value="Delete" class="btn btn-danger"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>