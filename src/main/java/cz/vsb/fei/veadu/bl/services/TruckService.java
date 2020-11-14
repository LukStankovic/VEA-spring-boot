package cz.vsb.fei.veadu.bl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.vsb.fei.veadu.bl.dao.vehicles.TruckDao;
import cz.vsb.fei.veadu.entities.vehicles.Truck;

@Service
@Transactional
public class TruckService {

    @Autowired
    private TruckDao dao;

    public TruckService() {
        super();
    }

    public void create(final Truck entity) {
        dao.create(entity);
    }
    
    public void edit(final Truck entity) {
		dao.update(entity);
    }

    public Truck findOne(final long id) {
        return dao.findOne(id);
    }

    public List<Truck> findAll() {
        return dao.findAll();
    }
    
    public void deleteById(final long id) {
    	dao.deleteById(id);
    }

}