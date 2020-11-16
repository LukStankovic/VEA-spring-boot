package cz.vsb.fei.veadu.bl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.vsb.fei.veadu.bl.dao.vehicles.CarDao;
import cz.vsb.fei.veadu.entities.vehicles.Car;

@Service
@Transactional
public class CarService {

    @Autowired
    private CarDao dao;

    @Autowired
    private GarageService garageService;
    
    public CarService() {
        super();
    }

    public void create(final Car entity) {
        dao.create(entity);
    }
    
    public void edit(final Car entity) {
		dao.update(entity);
    }

    public Car findOne(final long id) {
        return dao.findOne(id);
    }

    public List<Car> findAll() {
        return dao.findAll();
    }
    
    public void deleteById(final long id) {
    	dao.deleteById(id);
    }

}