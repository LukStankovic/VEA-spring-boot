package cz.vsb.fei.veadu.bl.dao.vehicles;

import org.springframework.stereotype.Repository;

import cz.vsb.fei.veadu.bl.dao.AbstractDao;
import cz.vsb.fei.veadu.entities.vehicles.Truck;


@Repository
public class TruckDao extends AbstractDao<Truck> implements ITruckDao {

	public TruckDao(){
		setEntityClass(Truck.class);
   }
	
}
