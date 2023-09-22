package vn.edu.iuh.fit.huynhhuuphuoc_week2.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.models.Employee;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        employeeRepository = new EmployeeRepository();
    }

    public void insertEmp(Employee employee) {
        employeeRepository.insertEmp(employee);
    }

    public void updateEmp(Employee employee) {
        employeeRepository.update(employee);
    }

    public boolean deleteEmp(long id) {
        Optional<Employee> op = employeeRepository.findById(id);
        if (op.isPresent()) {
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.TERMINATED);
            return true;
        }
        return false;
    }

    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAll() {
        return employeeRepository.getAllEmp();
    }
}
