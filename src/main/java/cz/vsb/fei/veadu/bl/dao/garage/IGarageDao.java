package cz.vsb.fei.veadu.bl.dao.garage;

import java.util.List;

import cz.vsb.fei.veadu.entities.Garage;

public interface IGarageDao {
	
    Garage findOne(long id);

    List<Garage> findAll();

    void create(Garage entity);

    Garage update(Garage entity);

    void delete(Garage entity);

    void deleteById(long entityId);
    
}
