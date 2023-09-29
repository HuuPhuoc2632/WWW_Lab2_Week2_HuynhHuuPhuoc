package vn.edu.iuh.fit.huynhhuuphuoc_week2.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.models.Employee;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.services.EmployeeServices;

import java.util.List;
import java.util.Optional;

@Path("/employees")
public class EmployeeResources {
    private final EmployeeServices employeeServices;
    private final Logger  logger= LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeResources() {
        employeeServices = new EmployeeServices();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        List<Employee> employeeList = employeeServices.getAll();
        return Response.ok(employeeList).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmp(@PathParam("id") long eid) {
        Employee empOpt = employeeServices.findById(eid);
        if (empOpt.getEmpId()!=null) {
            return Response.ok(empOpt).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}