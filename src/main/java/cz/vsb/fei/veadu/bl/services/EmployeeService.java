package cz.vsb.fei.veadu.bl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.vsb.fei.veadu.bl.dao.employee.EmployeeDao;
import cz.vsb.fei.veadu.entities.Employee;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeDao dao;

    public EmployeeService() {
        super();
    }

    public void create(final Employee entity) {
        dao.create(entity);
    }
    
    public void edit(final Employee entity) {
		dao.update(entity);
    }

    public Employee findOne(final long id) {
        return dao.findOne(id);
    }

    public List<Employee> findAll() {
        return dao.findAll();
    }
    
    public void deleteById(final long id) {
    	dao.deleteById(id);
    }

}