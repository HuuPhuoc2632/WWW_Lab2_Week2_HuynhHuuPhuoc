package vn.edu.iuh.fit.huynhhuuphuoc_week2.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.models.Employee;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.models.Order;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.services.EmployeeService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Path("/employees")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource() {
        employeeService = new EmployeeService();
    }

    @GET
    @Produces("application/json")
    public Response getAlll() {
        List<Employee> employeeList = employeeService.getAll();
        return Response.ok(employeeList).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmp(@PathParam("id") long eid) {
        Optional<Employee> emp= employeeService.findById(eid);
        if (emp.isPresent()) {
            return Response.ok(emp.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
