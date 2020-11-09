package cz.vsb.fei.veadu.bl.dao;

import cz.vsb.fei.veadu.entities.Garage;
import org.springframework.stereotype.Repository;

@Repository
public class GarageDao extends AbstractDao<Garage> implements IGarageDao {

	public GarageDao(){
		setEntityClass(Garage.class);
   }

}
