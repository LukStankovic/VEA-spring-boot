package cz.vsb.fei.veadu.bl.services;

import cz.vsb.fei.veadu.bl.dao.stock.StockDao;
import cz.vsb.fei.veadu.entities.jdbc.Stock;
import javassist.NotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

	@Autowired
	private StockDao stockDao;

	public StockService() {
		super();
	}
	
	public void create(Stock stock) {
		stockDao.insert(stock);
	}
	
	public void edit(Stock stock) {
		stockDao.update(stock);
	}
	
	public void deleteById(long id) {
		stockDao.delete(id);
	}
	
	public List<Stock> getAll() {
		return stockDao.getAll();
	}
	
	public Stock findOne(long id) throws NotFoundException {
		return stockDao.find(id);
	}
	
	public List<Stock> findAll() {
		return stockDao.getAll();
	}
}
