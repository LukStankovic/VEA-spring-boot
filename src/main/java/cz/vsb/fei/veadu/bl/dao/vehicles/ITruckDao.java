package cz.vsb.fei.veadu.bl.dao.vehicles;

import java.util.List;

import cz.vsb.fei.veadu.entities.vehicles.Truck;

public interface ITruckDao {
	
	Truck findOne(long id);

    List<Truck> findAll();

    void create(Truck entity);

    Truck update(Truck entity);

    void delete(Truck entity);

    void deleteById(long entityId);
    
}
