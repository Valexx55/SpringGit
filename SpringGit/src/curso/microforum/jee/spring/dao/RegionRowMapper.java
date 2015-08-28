package curso.microforum.jee.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import curso.microforum.jee.spring.Regions;

public class RegionRowMapper implements RowMapper<Regions> {

	@Override
	public Regions mapRow(ResultSet rs, int nfila) throws SQLException {

		Regions region = null;
		
		region = new Regions(rs.getLong("REGION_ID"), rs.getString("REGION_NAME"));
		
		return region;
	}

}
