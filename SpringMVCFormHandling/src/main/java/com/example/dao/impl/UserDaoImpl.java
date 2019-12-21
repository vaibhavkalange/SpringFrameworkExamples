package com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.example.dao.UserDao;
import com.example.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public User findById(Integer id) {
		String sql = "SELECT * FROM user WHERE id=:id";
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);

		User result = null;
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<User> findAllUser() {
		String sql = "SELECT * FROM user";
		return namedParameterJdbcTemplate.query(sql, new UserMapper());
	}

	@Override
	public void save(User user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO user(name, email, address, country, frameworks, skills)"
				+ "VALUES(:name,:email,:address,:country,:frameworks,:skills)";

		namedParameterJdbcTemplate.update(sql, getGeneratedParamByModel(user), keyHolder);
		user.setId(keyHolder.getKey().intValue());
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE user SET name=:name, email=:email, address=:address,"
				+ "country=:country, frameworks=:frameworks, skills=:skills WHERE id=:id";

		namedParameterJdbcTemplate.update(sql, getGeneratedParamByModel(user));
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM user WHERE id=:id";
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);

		namedParameterJdbcTemplate.update(sql, params);
	}

	private static final class UserMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowCount) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));
			user.setCountry(rs.getString("country"));
			user.setFrameworks(convertDelimitedStringToList(rs.getString("frameworks")));
			user.setSkills(convertDelimitedStringToList(rs.getString("skills")));
			return user;
		}
	}

	private static List<String> convertDelimitedStringToList(String delimitedString) {
		List<String> result = new ArrayList<>();
		if (!StringUtils.isEmpty(delimitedString))
			result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
		return result;
	}

	private String convertDelimitedListToString(List<String> list) {
		if (list != null)
			return StringUtils.arrayToCommaDelimitedString(list.toArray());
		return null;
	}

	private MapSqlParameterSource getGeneratedParamByModel(User user) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", user.getId());
		params.addValue("name", user.getName());
		params.addValue("email", user.getEmail());
		params.addValue("address", user.getAddress());
		params.addValue("country", user.getCountry());
		params.addValue("frameworks", convertDelimitedListToString(user.getFrameworks()));
		params.addValue("skills", convertDelimitedListToString(user.getSkills()));

		return params;
	}
}
