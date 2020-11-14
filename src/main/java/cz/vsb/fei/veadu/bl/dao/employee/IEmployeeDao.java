package cz.vsb.fei.veadu.bl.dao.employee;

import java.util.List;

import cz.vsb.fei.veadu.entities.Employee;

public interface IEmployeeDao {
	
    Employee findOne(long id);

    List<Employee> findAll();

    void create(Employee entity);

    Employee update(Employee entity);

    void delete(Employee entity);

    void deleteById(long entityId);
    
}
