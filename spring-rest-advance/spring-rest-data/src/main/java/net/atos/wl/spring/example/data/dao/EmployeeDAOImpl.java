/*
 * Copyright: 2016, Atos.
 */
package net.atos.wl.spring.example.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import net.atos.wl.spring.example.common.dto.EmployeeSearchDto;
import net.atos.wl.spring.example.data.entity.Employee;

/**
 * Implementation class for
 * <code>net.atos.wl.spring.example.data.dao.EmployeeDAO</code>.
 * 
 * @author Rupesh Deshmukh
 */
@Repository
public class EmployeeDAOImpl extends AbstractJpaDAO<Employee> implements EmployeeDAO {

    /**
     * Default constructor.
     */
    public EmployeeDAOImpl() {
        this.setClazz(Employee.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee findEmployeeBySalaryCode(final int salaryCode) {

        final Query query = this.entityManager.createQuery("from employee e where e.salaryCode = :salaryCode");
        query.setParameter("salaryCode", salaryCode);

        return (Employee) query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Employee> findEmployeesBySearchCriteria(final EmployeeSearchDto employeeSearch) {

        final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        final Root<Employee> employee = criteriaQuery.from(Employee.class);
        criteriaQuery.select(employee);

        final List<Predicate> predicateList = new ArrayList<>();

        if (!StringUtils.isEmpty(employeeSearch.getFirstName())) {
            final Predicate firstNamePredicate =
                            criteriaBuilder.like(criteriaBuilder.upper(employee.<String> get("firstName")),
                                            "%" + employeeSearch.getFirstName().toUpperCase() + "%");
            predicateList.add(firstNamePredicate);
        }

        if (!StringUtils.isEmpty(employeeSearch.getLastName())) {
            final Predicate lastNamePredicate =
                            criteriaBuilder.like(criteriaBuilder.upper(employee.<String> get("lastName")),
                                            "%" + employeeSearch.getLastName().toUpperCase() + "%");
            predicateList.add(lastNamePredicate);
        }

        if (employeeSearch.getSalaryCode() != null && employeeSearch.getSalaryCode() != 0) {
            final Predicate salaryCodePredicate =
                            criteriaBuilder.equal(employee.<Integer> get("salaryCode"), employeeSearch.getSalaryCode());
            predicateList.add(salaryCodePredicate);
        }

        final Predicate[] predicates = new Predicate[predicateList.size()];
        criteriaQuery.where(predicateList.toArray(predicates));

        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }
}
