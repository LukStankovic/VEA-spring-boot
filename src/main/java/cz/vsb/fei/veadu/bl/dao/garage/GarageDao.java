package cz.vsb.fei.veadu.bl.dao.garage;

import cz.vsb.fei.veadu.bl.dao.AbstractDao;
import cz.vsb.fei.veadu.entities.Garage;
import org.springframework.stereotype.Repository;

@Repository
public class GarageDao extends AbstractDao<Garage> implements IGarageDao {

	public GarageDao(){
		setEntityClass(Garage.class);
   }

}
