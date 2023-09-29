package vn.edu.iuh.fit.huynhhuuphuoc_week2.front_end.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.glassfish.jersey.internal.inject.Custom;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.models.Customer;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.front_end.models.EmployeeModels;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.models.Employee;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@WebServlet("/employeeController")
public class EmployeeControllers extends HttpServlet {
//    @Inject
//    private CustomerModel customerModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        EmployeeModels customerModel = new EmployeeModels();

        String action = req.getParameter("action");
        if (action.equals("getAllCustomer")) {
            res.sendRedirect("customer.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        EmployeeModels employeeModels = new EmployeeModels();

        String action = req.getParameter("action");
        System.out.println(action);

        switch (action) {
            case "InsertEmp":
                employeeModels.insertEmp(req, res);
                res.sendRedirect("employee.jsp");
                break;
            case "UpdateEmp":
                try {
                    employeeModels.updateEmp(req, res);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                res.sendRedirect("employee.jsp");
                break;
            case "DeleteEmp":
                employeeModels.deleteEmp(req, res);
                res.sendRedirect("employee.jsp");
                break;
        }
    }
}

