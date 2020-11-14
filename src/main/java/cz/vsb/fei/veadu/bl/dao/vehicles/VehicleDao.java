package cz.vsb.fei.veadu.bl.dao.vehicles;

import org.springframework.stereotype.Repository;

import cz.vsb.fei.veadu.bl.dao.AbstractDao;
import cz.vsb.fei.veadu.entities.vehicles.Vehicle;

@Repository
public class VehicleDao extends AbstractDao<Vehicle> {

	public VehicleDao(){
		setEntityClass(Vehicle.class);
   }
	
}
