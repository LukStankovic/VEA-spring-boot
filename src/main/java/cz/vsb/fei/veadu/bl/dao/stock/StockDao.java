package cz.vsb.fei.veadu.bl.dao.stock;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import cz.vsb.fei.veadu.entities.jdbc.Stock;
import javassist.NotFoundException;

@Service
public class StockDao {

	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcInsert stockInsert;
		
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		stockInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("Stock").usingGeneratedKeyColumns("id")
				.usingColumns("name", "location", "area");
	}
	
	@PostConstruct
	public void postConstructor() {
		try {
			String dbProducerName;
			try (Connection con = jdbcTemplate.getDataSource().getConnection()) {
				DatabaseMetaData metaData = con.getMetaData();
				dbProducerName = metaData.getDatabaseProductName();
			}
			String sqlCreateTable;
			if ("Apache Derby".equals(dbProducerName)) {
				sqlCreateTable = "CREATE TABLE Stock (id INTEGER NOT NULL "
						+ "GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
						+ "name varchar(255), location varchar(255), "
						+ "area int";
			} else if ("H2".equals(dbProducerName)) {
				sqlCreateTable = "CREATE TABLE Stock(id INTEGER NOT NULL " + "AUTO_INCREMENT," + " name varchar(255), "
						+ "location varchar(255), " + "area int);";
			} else {
				throw new RuntimeException("Unsuported database type");
			}
			jdbcTemplate.update(sqlCreateTable);
		} catch (DataAccessException e) {
			System.out.println("Table already exist.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Stock insert(Stock stock) {
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(stock);
		Number key = stockInsert.executeAndReturnKey(source);
		stock.setId(key.longValue());
		
		return stock;
	}
	
	public Stock update(Stock stock) {
		jdbcTemplate.update("UPDATE Stock SET name = ?, location = ?, area = ?", stock.getName(), stock.getLocation(), stock.getArea());
		
		return stock;
	}
	
    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM Stock WHERE id= ?", id);
    }

	public List<Stock> getAll(){
		return jdbcTemplate.query("SELECT * FROM Stock", new StockMapper());
	}
	

	public Stock find(long id) throws NotFoundException {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM Stock WHERE id=?", new Object[] {Long.valueOf(id)} , new StockMapper());
		} catch (EmptyResultDataAccessException exc) {
			throw new NotFoundException("Stock was not found");
		}
	}
}
