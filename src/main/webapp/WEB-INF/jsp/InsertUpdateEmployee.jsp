<%--
  Created by IntelliJ IDEA.
  User: vchuhai
  Date: 10.04.2020
  Time: 17:02
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
        <form action="/departments/employees" method="post">
            <input type="hidden" name="departmentId" value="${departmentId}">
            <input type="submit" value="List of Employees" class="btn btn-dark"/>
        </form>
    </h3>


    <c:if test="${employee != null}">
    <form action="update" method="post">

        </c:if>
        <c:if test="${employee == null}">
        <form action="update" method="post">
            </c:if>


            <h3 class="w-100 d-flex justify-content-center">
                <c:if test="${employee.id != null}">
                    Edit Employee
                </c:if>
                <c:if test="${employee.id == null}">
                    Add New Employee
                </c:if>
            </h3>

            <c:if test="${employee.id != null}">
                <input type="hidden" name="id" value="<c:out value='${employee.id}' />"/>
            </c:if>

            <div class="form-group row">
                <label for="email" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10">
                    <input type="text" name="email" class="form-control" id="email"
                           value="<c:out value='${employee.email}' />"
                    />
                    <c:if test="${map.email != null}">
                        <div class="alert alert-warning  show" role="alert">
                            <c:out value='${map.email}'/>
                        </div>
                    </c:if>
                </div>
            </div>

            <div class="form-group row">
                <label for="date" class="col-sm-2 col-form-label">Date</label>
                <div class="col-sm-10">
                    <input type="date" name="recruitmentDate" id="date" class="form-control"
                           value="<c:out value='${employee.recruitmentDate}' />"
                    />
                    <c:if test="${map.recruitmentDate != null}">
                        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                            <c:out value='${map.recruitmentDate}'/>
                        </div>

                    </c:if>
                </div>
            </div>

            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" name="name" id="name" class="form-control"
                           value="<c:out value='${employee.name}' />"
                    />
                    <c:if test="${map.name != null}">
                        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                            <c:out value='${map.name}'/>
                        </div>
                    </c:if>
                </div>
            </div>

            <div class="form-group row">
                <label for="salary" class="col-sm-2 col-form-label">Salary</label>
                <div class="col-sm-10">
                    <input type="number" name="salary" id="salary" class="form-control"
                           value="<c:out value='${employee.salary}' />"
                    />
                    <c:if test="${map.salary != null}">
                        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                            <c:out value='${map.salary}'/>
                        </div>

                    </c:if>
                </div>
            </div>

            <div class="d-flex justify-content-end">
                <input type="submit" value="Save" class="btn btn-dark"/>
            </div>

            <input type="hidden" name="departmentId" value="${departmentId}">
        </form>


</div>
</body>
</html>

