package vn.edu.iuh.fit.huynhhuuphuoc_week2.services;

import vn.edu.iuh.fit.huynhhuuphuoc_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.models.Employee;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeServices {
    private EmployeeRepository employeeRepository;

    public EmployeeServices() {
        employeeRepository = new EmployeeRepository();
    }

    public void insertEmp(Employee employee) {
        employeeRepository.insertEmp(employee);
    }

    public void updateEmp(Employee employee) {
        employeeRepository.updateEmp(employee);
    }

    public boolean deleteEmp(long id) {
        Employee e = employeeRepository.findById(id);

        return employeeRepository.deleteEmp(e);
    }

    public Employee findById(long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAll() {
        return employeeRepository.getAllEmp();
    }

}
