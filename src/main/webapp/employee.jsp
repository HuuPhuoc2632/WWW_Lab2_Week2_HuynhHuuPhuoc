
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.huynhhuuphuoc_week2.services.EmployeeServices" %>
<%@ page import="vn.edu.iuh.fit.huynhhuuphuoc_week2.models.Employee" %>

<%-- Import Bootstrap CSS --%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<h1>Cutomer</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Full name</th>
        <th>Address</th>
        <th>Email</th>
        <th>Date of birth</th>
        <th>Phone number</th>
        <th>Status</th>
    </tr>
    <%
        EmployeeServices employeeServices = new EmployeeServices();
        List<Employee> le = employeeServices.getAll();
        for (Employee em : le) {
    %>
    <tr>
        <td><%= em.getEmpId() %></td>
        <td><%= em.getFullName() %></td>
        <td><%= em.getAddress() %></td>
        <td><%= em.getEmail() %></td>
        <td><%= em.getDob() %></td>
        <td><%= em.getPhone() %></td>
        <td><%= em.getStatus() %></td>
    </tr>
    <%
        }
    %>
</table>
<br />
<form action="employeeController" method="post">
    <label>ID:</label>
    <input type="text" name="id">
    <br />
    <label>Full name: </label>
    <input type="text" name="name">
    <br />
    <label>Address: </label>
    <input type="text" name="address">
    <br />
    <label>Email: </label>
    <input type="text" name="email">
    <br />
    <label>Dob: </label>
    <input type="date" name="date of birth">
    <br />
    <label>Phone number: </label>
    <input type="text" name="phone">
    <br />
    <label for="status">Status:</label>
    <select class="form-control" id="status" name="status" required>
        <option value="ACTIVE" selected>Active</option>
        <option value="IN_ACTIVE">Inactive</option>
        <option value="TERMINATED">Terminated</option>
    </select>
    <button type="submit" name="action" value="InsertEmp">
        Add
    </button>
    <button type="submit" name="action" value="UpdateEmp">
        Update
    </button>
    <button type="reset">Clear</button>
    <br />
    <input type="text" name="deleteId" placeholder="write ID of employee you want to delete">
    <button type="submit" name="action" value="DeleteEmp">
        Delete

    </button>
</form>
</body>
</html>
