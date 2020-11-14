package cz.vsb.fei.veadu.bl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.vsb.fei.veadu.bl.dao.vehicles.VehicleDao;
import cz.vsb.fei.veadu.entities.vehicles.Vehicle;

@Service
@Transactional
public class VehicleService {

    @Autowired
    private VehicleDao dao;

    public VehicleService() {
        super();
    }

    public void create(final Vehicle entity) {
        dao.create(entity);
    }
    
    public void edit(final Vehicle entity) {
		dao.update(entity);
    }

    public Vehicle findOne(final long id) {
        return dao.findOne(id);
    }

    public List<Vehicle> findAll() {
        return dao.findAll();
    }
    
    public void deleteById(final long id) {
    	dao.deleteById(id);
    }

}