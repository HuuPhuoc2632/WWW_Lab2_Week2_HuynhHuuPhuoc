package vn.edu.iuh.fit.huynhhuuphuoc_week2.repositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.models.Employee;



import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction trans;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeRepository() {
        em = Persistence.createEntityManagerFactory("HuuPhuoc").createEntityManager();
        trans = em.getTransaction();
    }

    public void insertEmp(Employee employee) {
        try {
            trans.begin();
            em.persist(employee);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateEmp(Employee employee) {
        try {
            trans.begin();
            em.merge(employee);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean deleteEmp(Employee e) {
        if (e.getEmpId()!=null) {
            e.setStatus(EmployeeStatus.TERMINATED);
            try {
                trans.begin();
                em.merge(e);
                trans.commit();
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public Employee findById(long id) {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.empId=:id", Employee.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Employee> getAllEmp() {
        return em.createNamedQuery("Employee.findAll", Employee.class)
                .getResultList();
    }
}
