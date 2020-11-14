package cz.vsb.fei.veadu.bl.dao.vehicles;

import java.util.List;

import cz.vsb.fei.veadu.entities.vehicles.Car;

public interface ICarDao {
	
	Car findOne(long id);

    List<Car> findAll();

    void create(Car entity);

    Car update(Car entity);

    void delete(Car entity);

    void deleteById(long entityId);
    
}
