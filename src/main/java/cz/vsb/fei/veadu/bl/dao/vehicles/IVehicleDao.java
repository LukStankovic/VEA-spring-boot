package cz.vsb.fei.veadu.bl.dao.vehicles;

import java.util.List;

import cz.vsb.fei.veadu.entities.vehicles.Vehicle;

public interface IVehicleDao {
	
    Vehicle findOne(long id);

    List<Vehicle> findAll();

    void create(Vehicle entity);

    Vehicle update(Vehicle entity);

    void delete(Vehicle entity);

    void deleteById(long entityId);
    
}
