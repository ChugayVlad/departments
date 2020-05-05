<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"  %>
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
        <form id="add_department" action="departments/edit">
            <input type="submit" value="Add Department" class="btn btn-dark"/>
        </form>
    </h3>

    <table class="table">
        <h3 class="text-muted">List of Departments</h3>
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="department" items="${departments}">
            <tr>
                <th scope="row"><c:out value="${department.id}"/></th>
                <td><c:out value="${department.name}"/></td>
                <td class="d-flex align-items-center" >

                    <form action="employees" method="post" >
                        <input type="hidden" name="departmentId" value="${department.id}">
                        <input type="submit" value="List of employees" class="btn btn-secondary"/>
                    </form>

                    <form action="departments/edit" method="post">
                        <input type="hidden" name="id" value="${department.id}">
                        <input type="submit" value="Edit" class="btn btn-info"/>
                    </form>

                    <form action="departments/delete" method="post" >
                        <input type="hidden" name="id" value="${department.id}">
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