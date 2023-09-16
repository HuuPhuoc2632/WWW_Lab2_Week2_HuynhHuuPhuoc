package vn.edu.iuh.fit.huynhhuuphuoc_week2.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.models.Employee;

@Stateless
public class EmployeeService {
    @PersistenceContext
    private EntityManager entityManager;

    public void createEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    public Employee getEmployeeById(Long empId) {
        return entityManager.find(Employee.class, empId);
    }

    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    public void deleteEmployee(Long empId) {
        Employee employee = entityManager.find(Employee.class, empId);
        if (employee != null) {
            employee.setStatus(EmployeeStatus.IN_ACTIVE);
            entityManager.merge(employee);
        }
    }
}
