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

	public List<Department> getDepListAll() {
		List<Department> list = new ArrayList<Department>();
                Statement stat = null;
                ResultSet rs = null;
		if (isConnection(conn)) {
                    try{
			stat = conn.createStatement();
			rs = stat.executeQuery(SELECT_ALL_DEP);
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
                    } catch(SQLException e){
                        LOG.error(e.getMessage(), e);
                    } finally {
                        try{
                            if(rs != null){
                                rs.close();
                            }
                        } catch(SQLException e1){
                            LOG.error(e1.getMessage(), e1);
                        } finally {
                            try{
                                conn.close();
                            } catch(SQLException e2) {
                                LOG.error(e2.getMessage(), e2);
                            }
                        }
                    }
			return list;
		} else {
			return list;
		}
	}

	public List<Department> getDepListById(Long id) {
		List<Department> list = new ArrayList<Department>();
                PreparedStatement ps = null;
                ResultSet rs = null;
		if (isConnection(conn)) {
                    try{
			ps = conn.prepareStatement(SELECT_DEP_BY_ID);
			ps.setLong(1, id);
			rs = ps.executeQuery();
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
                    } catch(SQLException e){
                        LOG.error(e.getMessage(), e);
                    } finally {
                        try{
                            if(rs != null){
                                rs.close();
                            }
                        } catch(SQLException e1){
                            LOG.error(e1.getMessage(), e1);
                        } finally {
                            try{
                                conn.close();
                            } catch(SQLException e2) {
                                LOG.error(e2.getMessage(), e2);
                            }
                        }
                    }

			return list;
		} else {
			return list;
		}
	}

	public List<Department> getDepListByName(String name) {
		List<Department> list = new ArrayList<Department>();
                PreparedStatement ps = null;
                ResultSet rs = null;
		if (isConnection(conn)) {
                    try{
			ps = conn.prepareStatement(SELECT_DEP_BY_NAME);
			ps.setString(1, name);
			rs = ps.executeQuery();
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

                    } catch(SQLException e){
                        
                    } finally {
                        try{
                            if(ps != null){
                                ps.close();
                            }
                        } catch(SQLException e1){
                            LOG.error(e1.getMessage(), e1);
                        } finally {
                            try{
                                conn.close();
                            } catch(SQLException e2) {
                                LOG.error(e2.getMessage(), e2);
                            }
                        }
                    }
			return list;
		} else {
			return list;
		}
	}

	public List<Department> getDepListByAddress(String address){
		List<Department> list = new ArrayList<Department>();
                PreparedStatement ps = null;
                ResultSet rs = null;
		if (isConnection(conn)) {
                    try{
			ps = conn.prepareStatement(SELECT_DEP_BY_ADDRESS);
			ps.setString(1, address);
			rs = ps.executeQuery();
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
                    } catch(SQLException e) {
                        LOG.error(e.getMessage(), e);
                    } finally {
                        try{
                            if(ps != null){
                                ps.close();
                            }
                        } catch(SQLException e1){
                            LOG.error(e1.getMessage(), e1);
                        } finally {
                            try{
                                conn.close();
                            } catch(SQLException e2) {
                                LOG.error(e2.getMessage(), e2);
                            }
                        }
                    }
			return list;
		} else {
			return list;
		}
	}

	public List<Department> getDepListByRating(Integer rating){
		List<Department> list = new ArrayList<Department>();
                PreparedStatement ps = null;
                ResultSet rs = null;
		if (isConnection(conn)) {
                    try {
			ps = conn.prepareStatement(SELECT_DEP_BY_RATING);
			ps.setInt(1, rating);
			rs = ps.executeQuery();
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

                    } catch(Exception e) {
                        LOG.error(e.getMessage(), e);
                    } finally {
                        try{
                            if(ps != null){
                                ps.close();
                            }
                        } catch(SQLException e1){
                            LOG.error(e1.getMessage(), e1);
                        } finally {
                            try{
                                conn.close();
                            } catch(SQLException e2) {
                                LOG.error(e2.getMessage(), e2);
                            }
                        }
                    }

			return list;
		} else {
			return list;
		}
	}

	public List<Department> getDepListByDate(Long date) {
		List<Department> list = new ArrayList<Department>();
                PreparedStatement ps = null;
                ResultSet rs = null;
		if (isConnection(conn)) {
                    try{
			ps = conn.prepareStatement(SELECT_DEP_BY_DATE);
			ps.setTimestamp(1, new Timestamp(date));
			rs = ps.executeQuery();
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
                    } catch(SQLException e) {
                      LOG.error(e.getMessage(), e);
                    } 
                    finally {
                        try{
                            if(rs != null){
                                ps.close();
                            }
                        } catch(SQLException e1){
                            LOG.error(e1.getMessage(), e1);
                        } finally {
                            try{
                                conn.close();
                            } catch(SQLException e2) {
                                LOG.error(e2.getMessage(), e2);
                            }
                        }
                    }
			return list;
		} else {
			return list;
		}
	}

	public List<Department> getDepListByState(Boolean state){
		List<Department> list = new ArrayList<Department>();
                PreparedStatement ps = null;
                ResultSet rs = null;
		if (isConnection(conn)) {
                    try{
			ps = conn.prepareStatement(SELECT_DEP_BY_STATE);
			ps.setBoolean(1, state);
			rs = ps.executeQuery();
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
                    }catch(Exception e){
                        LOG.error(e.getMessage(), e);
                     } finally {
                        try{
                            if(rs != null){
                                rs.close();
                            }
                        } catch(SQLException e1){
                            LOG.error(e1.getMessage(), e1);
                        } finally {
                            try{
                                conn.close();
                            } catch(SQLException e2) {
                                LOG.error(e2.getMessage(), e2);
                            }
                        }
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
