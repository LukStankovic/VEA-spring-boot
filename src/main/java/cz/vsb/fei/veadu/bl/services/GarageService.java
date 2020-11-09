package cz.vsb.fei.veadu.bl.services;

import java.util.List;

import cz.vsb.fei.veadu.bl.dao.GarageDao;
import cz.vsb.fei.veadu.entities.Garage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GarageService {

    @Autowired
    private GarageDao dao;

    public GarageService() {
        super();
    }

    public void create(final Garage entity) {
        dao.create(entity);
    }
    
    public void edit(final Garage entity) {
		dao.update(entity);
    }

    public Garage findOne(final long id) {
        return dao.findOne(id);
    }

    public List<Garage> findAll() {
        return dao.findAll();
    }
    
    public void deleteById(final long id) {
    	dao.deleteById(id);
    }

}