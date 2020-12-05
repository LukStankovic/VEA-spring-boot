package cz.vsb.fei.veadu.bl.dao.stock;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import cz.vsb.fei.veadu.entities.jdbc.Stock;


public class StockMapper implements RowMapper<Stock> {

	@Override
	public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Stock(
			rs.getInt("id"), 
			rs.getString("name"), 
			rs.getString("location"),
			rs.getInt("area")
		);
	}

}