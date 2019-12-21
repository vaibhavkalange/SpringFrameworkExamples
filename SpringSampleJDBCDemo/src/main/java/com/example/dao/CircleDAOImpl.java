package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.example.shape.Circle;

@Component
public class CircleDAOImpl {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Circle getCircleById(int id) {

		Connection con = null;
		Circle circle = new Circle();
		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM CIRCLE WHERE ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				circle.setId(id);
				circle.setName(rs.getString("NAME"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return circle;
	}

	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public String getCircleName(int id) {
		String sql = "SELECT NAME FROM CIRCLE WHERE ID=?";
		return jdbcTemplate.queryForObject(sql, String.class, new Object[] { id });
	}

	public Circle getCircle(int id){
		String sql = "SELECT * FROM CIRCLE WHERE ID=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CircleMapper());
	}
	
	public List<Circle> getAllCircle(){
		String sql = "SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql, new CircleMapper());
	}

	public void addCircle(Circle circle){
		String sql = "INSERT INTO CIRCLE(ID, NAME) VALUES(?,?)";
		jdbcTemplate.update(sql, new Object[]{circle.getId(),circle.getName()});
	}
	
	public void insertCircle(Circle circle){
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String sql = "INSERT INTO CIRCLE(ID, NAME) VALUES(:id,:name)";
		SqlParameterSource parameter = new MapSqlParameterSource("id",circle.getId())
				.addValue("name", circle.getName());
		
		namedParameterJdbcTemplate.update(sql, parameter);
		
	}
	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Circle circle = new Circle();
			circle.setId(rs.getInt("ID"));
			circle.setName(rs.getString("NAME"));
			
			return circle;
		}

	}
}
