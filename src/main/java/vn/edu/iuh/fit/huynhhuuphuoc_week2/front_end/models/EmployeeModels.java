package vn.edu.iuh.fit.huynhhuuphuoc_week2.front_end.models;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.models.Employee;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.services.EmployeeServices;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class EmployeeModels {


    public void insertEmp(HttpServletRequest req, HttpServletResponse res){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        EmployeeServices employeeServices = new EmployeeServices();
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        Date dob = null;
        if(!req.getParameter("date of birth").isEmpty()) {
            try {
                dob = dateFormat.parse(req.getParameter("date of birth"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        String phone = req.getParameter("phone");
        String status =req.getParameter("status");

        Employee e = new Employee(null,name, dob, email, phone, address, EmployeeStatus.valueOf(status));
        employeeServices.insertEmp(e);

    }

    public List<Employee> getAllEmployee(){
        EmployeeServices EmployeeService = new EmployeeServices();
        return EmployeeService.getAll();
    }

    public void updateEmp(HttpServletRequest req, HttpServletResponse res) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        EmployeeServices employeeService = new EmployeeServices();

       Employee e = employeeService.findById(Long.parseLong(req.getParameter("id")));

        String address, email, name, phone;
        if(!req.getParameter("address").isEmpty())
            e.setAddress(req.getParameter("address"));
        else{
            e.setAddress(e.getAddress());
        }
        if(!req.getParameter("email").isEmpty())
            e.setEmail(req.getParameter("email"));
        else{
            e.setEmail(e.getEmail());
        }
        if(!req.getParameter("name").isEmpty())
            e.setFullName(req.getParameter("name"));
        else{
            e.setFullName(e.getFullName());
        }
        if(!req.getParameter("phone").isEmpty())
            e.setPhone(req.getParameter("phone"));
        else{
            e.setPhone(e.getPhone());
        }
        if(!req.getParameter("date of birth").isEmpty())
            e.setDob(dateFormat.parse(req.getParameter("date of birth")));
        else{
            e.setDob(e.getDob());
        }
        if(!req.getParameter("status").isEmpty()) {
            String status = req.getParameter("status");
            e.setStatus(EmployeeStatus.valueOf(status));
        }
        else{
            e.setStatus(e.getStatus());
        }
        employeeService.updateEmp(e);
    }

    public  void deleteEmp(HttpServletRequest req, HttpServletResponse res){
        EmployeeServices EmployeeService = new EmployeeServices();
        long id = Long.parseLong(req.getParameter("deleteId"));
        EmployeeService.deleteEmp(id);
    }
}
