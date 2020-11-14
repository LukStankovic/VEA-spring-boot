package cz.vsb.fei.veadu.bl.dao.employee;

import org.springframework.stereotype.Repository;

import cz.vsb.fei.veadu.bl.dao.AbstractDao;
import cz.vsb.fei.veadu.bl.dao.garage.IGarageDao;
import cz.vsb.fei.veadu.entities.Employee;

@Repository
public class EmployeeDao extends AbstractDao<Employee> implements IEmployeeDao {

	public EmployeeDao(){
		setEntityClass(Employee.class);
   }
	
}
