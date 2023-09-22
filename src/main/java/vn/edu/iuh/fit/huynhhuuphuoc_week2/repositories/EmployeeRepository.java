package vn.edu.iuh.fit.huynhhuuphuoc_week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.models.Employee;


import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private EntityManager em;



    public EmployeeRepository() {
        em = Persistence.createEntityManagerFactory("WWW_Lab2_Week2_HuynhHuuPhuoc").createEntityManager();
    }

    public void insertEmp(Employee employee) {
            em.persist(employee);
    }

    public void update(Employee employee) {
            em.merge(employee);
    }
    public void setStatus(Employee employee, EmployeeStatus employeeStatus ){
        employee.setStatus(employeeStatus);
    }


    public Optional<Employee> findById(long id) {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.empId=:id", Employee.class);
        query.setParameter("id", id);
        Employee employee = query.getSingleResult();
        return employee == null ? Optional.empty() : Optional.of(employee);
    }

    public List<Employee> getAllEmp() {
        return em.createNamedQuery("Employee.findAll", Employee.class)
                .getResultList();
    }
}