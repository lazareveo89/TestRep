package com.test.supportech.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.test.supportech.dao.ConnectToDb;
import com.test.supportech.dao.DepartmentDao;
import com.test.supportech.model.Department;
import org.apache.log4j.Logger;

public class DepartmentDaoImpl implements DepartmentDao {

        private static final Logger LOG = Logger.getLogger(DepartmentDaoImpl.class);
	private final String SELECT_ALL_DEP = "select * from departments";
	private final String SELECT_DEP_BY_ID = "select * from departments where id = ?";
	private final String SELECT_DEP_BY_NAME = "select * from departments where depName = ?";
	private final String SELECT_DEP_BY_ADDRESS = "select * from departments where depAddress = ?";
	private final String SELECT_DEP_BY_RATING = "select * from departments where depRating = ?";
	private final String SELECT_DEP_BY_DATE = "select * from departments where dateCreate = ?";
	private final String SELECT_DEP_BY_STATE = "select * from departments where depState = ?";
	private final String SELECT_DEP_BY_ABOUT = "select * from departments where depAbout like ?";

	private Connection conn = null;

	public DepartmentDaoImpl() {
		try {
			conn = new ConnectToDb().getConnection();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	public List<Department> getDepListAll() throws SQLException {
		List<Department> list = new ArrayList<Department>();
		if (isConnection(conn)) {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SELECT_ALL_DEP);
			while (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getLong("id"));
				dep.setDepName(rs.getString("depName"));
				dep.setDepAddr(rs.getString("depAddress"));
				dep.setRating(rs.getInt("depRating"));
				dep.setDepCreate(rs.getDate("dateCreate"));
				dep.setDepState(rs.getBoolean("depState"));
				dep.setAbout(rs.getString("depAbout"));
				list.add(dep);
			}
			if (!conn.isClosed()) {
				conn.close();
			}
			return list;
		} else {
			return list;
		}
	}

	public List<Department> getDepListById(Long id) throws SQLException {
		List<Department> list = new ArrayList<Department>();
		if (isConnection(conn)) {
			PreparedStatement ps = conn.prepareStatement(SELECT_DEP_BY_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getLong("id"));
				dep.setDepName(rs.getString("depName"));
				dep.setDepAddr(rs.getString("depAddress"));
				dep.setRating(rs.getInt("depRating"));
				dep.setDepCreate(rs.getDate("dateCreate"));
				dep.setDepState(rs.getBoolean("depState"));
				dep.setAbout(rs.getString("depAbout"));
				list.add(dep);
			}

			if (!conn.isClosed()) {
				conn.close();
			}

			return list;
		} else {
			return list;
		}
	}

	public List<Department> getDepListByName(String name) throws SQLException {
		List<Department> list = new ArrayList<Department>();
		if (isConnection(conn)) {
			PreparedStatement ps = conn.prepareStatement(SELECT_DEP_BY_NAME);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getLong("id"));
				dep.setDepName(rs.getString("depName"));
				dep.setDepAddr(rs.getString("depAddress"));
				dep.setRating(rs.getInt("depRating"));
				dep.setDepCreate(rs.getDate("dateCreate"));
				dep.setDepState(rs.getBoolean("depState"));
				dep.setAbout(rs.getString("depAbout"));
				list.add(dep);
			}

			if (!conn.isClosed()) {
				conn.close();
			}

			return list;
		} else {
			return list;
		}
	}

	public List<Department> getDepListByAddress(String address)	throws SQLException {
		List<Department> list = new ArrayList<Department>();
		if (isConnection(conn)) {
			PreparedStatement ps = conn.prepareStatement(SELECT_DEP_BY_ADDRESS);
			ps.setString(1, address);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getLong("id"));
				dep.setDepName(rs.getString("depName"));
				dep.setDepAddr(rs.getString("depAddress"));
				dep.setRating(rs.getInt("depRating"));
				dep.setDepCreate(rs.getDate("dateCreate"));
				dep.setDepState(rs.getBoolean("depState"));
				dep.setAbout(rs.getString("depAbout"));
				list.add(dep);
			}

			if (!conn.isClosed()) {
				conn.close();
			}

			return list;
		} else {
			return list;
		}
	}

	public List<Department> getDepListByRating(Integer rating)
			throws SQLException {
		List<Department> list = new ArrayList<Department>();
		if (isConnection(conn)) {
			PreparedStatement ps = conn.prepareStatement(SELECT_DEP_BY_RATING);
			ps.setInt(1, rating);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getLong("id"));
				dep.setDepName(rs.getString("depName"));
				dep.setDepAddr(rs.getString("depAddress"));
				dep.setRating(rs.getInt("depRating"));
				dep.setDepCreate(rs.getDate("dateCreate"));
				dep.setDepState(rs.getBoolean("depState"));
				dep.setAbout(rs.getString("depAbout"));
				list.add(dep);
			}

			if (!conn.isClosed()) {
				conn.close();
			}

			return list;
		} else {
			return list;
		}
	}

	public List<Department> getDepListByDate(Long date) throws SQLException {
		List<Department> list = new ArrayList<Department>();
		if (isConnection(conn)) {
			PreparedStatement ps = conn.prepareStatement(SELECT_DEP_BY_DATE);
			ps.setTimestamp(1, new Timestamp(date));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getLong("id"));
				dep.setDepName(rs.getString("depName"));
				dep.setDepAddr(rs.getString("depAddress"));
				dep.setRating(rs.getInt("depRating"));
				dep.setDepCreate(rs.getDate("dateCreate"));
				dep.setDepState(rs.getBoolean("depState"));
				dep.setAbout(rs.getString("depAbout"));
				list.add(dep);
			}

			if (!conn.isClosed()) {
				conn.close();
			}

			return list;
		} else {
			return list;
		}
	}

	public List<Department> getDepListByState(Boolean state)
			throws SQLException {
		List<Department> list = new ArrayList<Department>();
		if (isConnection(conn)) {
			PreparedStatement ps = conn.prepareStatement(SELECT_DEP_BY_STATE);
			ps.setBoolean(1, state);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getLong("id"));
				dep.setDepName(rs.getString("depName"));
				dep.setDepAddr(rs.getString("depAddress"));
				dep.setRating(rs.getInt("depRating"));
				dep.setDepCreate(rs.getDate("dateCreate"));
				dep.setDepState(rs.getBoolean("depState"));
				dep.setAbout(rs.getString("depAbout"));
				list.add(dep);
			}

			if (!conn.isClosed()) {
				conn.close();
			}

			return list;
		} else {
			return list;
		}
	}

	public List<Department> getDepListByAbout(String about) throws SQLException {
		List<Department> list = new ArrayList<Department>();
		if (isConnection(conn)) {
			PreparedStatement ps = conn.prepareStatement(SELECT_DEP_BY_ABOUT);
			ps.setString(1, "%"+about+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getLong("id"));
				dep.setDepName(rs.getString("depName"));
				dep.setDepAddr(rs.getString("depAddress"));
				dep.setRating(rs.getInt("depRating"));
				dep.setDepCreate(rs.getDate("dateCreate"));
				dep.setDepState(rs.getBoolean("depState"));
				dep.setAbout(rs.getString("depAbout"));
				list.add(dep);
			}

			if (!conn.isClosed()) {
				conn.close();
			}

			return list;
		} else {
			return list;
		}
	}

	private boolean isConnection(Connection conn) {
		if (conn != null) {
			return true;
		} else {
			return false;
		}
	}

}
