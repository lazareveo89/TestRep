package com.test.supportech.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.test.supportech.dao.DepartmentDao;
import com.test.supportech.daoimpl.DepartmentDaoImpl;
import com.test.supportech.model.Department;
import org.apache.log4j.Logger;

public class DepartmentTable extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
        private static final Logger LOG = Logger.getLogger(DepartmentTable.class);
	
	private final int COLUMNCOUNT = 7;
	   private List<Department> dataListNew = new ArrayList<Department>();
	   private String[] columnNames = {"ID", "Name", "Address", 
	       "Rating", "Date", "State", "About"};

	    /**
	     * 
	     * return table row count 
	     */
	    public int getRowCount() {
	    	return dataListNew.size();
	    }
	    /**
	     * 
	     * return table column count 
	     */
	    public int getColumnCount() {
	        return COLUMNCOUNT;
	    }
	    /**
	     * 
	     * @param rowIndex
	     * @param columnIndex
	     * @return value from table cell
	     */
	    public Object getValueAt(int rowIndex, int columnIndex) {
	    	Department dep = dataListNew.get(rowIndex);
	    	if (columnIndex == 0) {
		           return dep.getId();
		        } else if (columnIndex == 1) {
		           return dep.getDepName();
		        } else if (columnIndex == 2) {
		           return dep.getDepAddr();
		        } else if (columnIndex == 3) {
		           return dep.getRating();
		        } else if(columnIndex == 4){
		           return dep.getDepCreate();
		        }else if(columnIndex == 5){
		          return  dep.getDepState();
		        } else {
		        	return dep.getAbout();
		        }
	       
	    }
		/**
	         * method for add data to 1 row in table
	         * 
	         */
	       public void addData(List<Department> dep) {
	    	   dataListNew.addAll(dep);
	        }
	       
	       public void addData() {
	    	   DepartmentDao depDao = new DepartmentDaoImpl();
	    	   try{
	    		   List<Department> dep = depDao.getDepListAll();
	    		   addData(dep);
	    	   } catch(Exception e) {
	    		   LOG.error(e.getMessage(), e);
	    	   }
	       }

	       /**
	        * 
	        * @param column
	        * @return column name
	        */
	    @Override
	    public String getColumnName(int column) {
	        return columnNames[column];
	    }
	    
	    @Override
	    public boolean isCellEditable(int rowIndex, int columnIndex) {
	    	return true;
	    }
}