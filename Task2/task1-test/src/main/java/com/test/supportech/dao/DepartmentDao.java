package com.test.supportech.dao;

import java.sql.SQLException;
import java.util.List;

import com.test.supportech.model.Department;

public interface DepartmentDao {
	public List<Department> getDepListAll() throws SQLException;
	public List<Department> getDepListById(Long id) throws Exception;
	public List<Department> getDepListByName(String name) throws SQLException;
	public List<Department> getDepListByAddress(String adddress) throws SQLException;
	public List<Department> getDepListByRating(Integer rating) throws SQLException;
	public List<Department> getDepListByDate(Long date) throws SQLException;
	public List<Department> getDepListByState(Boolean state) throws SQLException;
	public List<Department> getDepListByAbout(String about) throws SQLException;
}
