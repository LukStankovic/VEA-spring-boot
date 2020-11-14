package cz.vsb.fei.veadu.bl.dao.vehicles;

import org.springframework.stereotype.Repository;

import cz.vsb.fei.veadu.bl.dao.AbstractDao;
import cz.vsb.fei.veadu.entities.vehicles.Car;

@Repository
public class CarDao extends AbstractDao<Car> implements ICarDao {

	public CarDao(){
		setEntityClass(Car.class);
   }
	
}
