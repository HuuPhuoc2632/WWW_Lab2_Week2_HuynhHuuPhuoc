
<%@ page import="vn.edu.iuh.fit.huynhhuuphuoc_week2.services.EmployeeServices" %>
<%@ page import="vn.edu.iuh.fit.huynhhuuphuoc_week2.models.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <!-- Sidebar -->
        <nav id="sidebar" class="col-md-3 col-lg-2 d-md-block bg-light sidebar">
            <div class="position-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="employee.jsp">
                            Employee
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- Content -->
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <!-- Your page content goes here -->
        </main>
    </div>
</div>

<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
