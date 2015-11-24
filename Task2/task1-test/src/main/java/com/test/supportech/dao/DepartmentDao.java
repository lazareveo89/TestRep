package com.test.supportech.dao;

import java.util.List;

import com.test.supportech.model.Department;

public interface DepartmentDao {
	public List<Department> getDepListAll();
	public List<Department> getDepListById(Long id);
	public List<Department> getDepListByName(String name);
	public List<Department> getDepListByAddress(String adddress);
	public List<Department> getDepListByRating(Integer rating);
	public List<Department> getDepListByDate(Long date);
	public List<Department> getDepListByState(Boolean state);
}
