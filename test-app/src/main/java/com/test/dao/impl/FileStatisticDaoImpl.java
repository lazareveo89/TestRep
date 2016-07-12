package com.test.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.dao.FileStatisticDao;
import com.test.model.FileStatistic;
import com.test.model.Statistic;
import com.test.util.ConnectToDb;

public class FileStatisticDaoImpl implements FileStatisticDao{

	private Connection connect = null;
	
	private static final Logger LOG = Logger.getLogger(FileStatisticDaoImpl.class.getName());
	
	//We can use JdbcTemplate
	@Override
	public List<FileStatistic> getFilesStatistic(Long id) {
		List<FileStatistic> list = new ArrayList<>();
		PreparedStatement ps = null;
        ResultSet rs = null;
		try {
			connect = ConnectToDb.getConnection();
			if(connect != null && !connect.isClosed()) {
				ps = connect.prepareStatement("select fileId,longWord,shortWord,rowLength,avgRowLength from fileStatistics where fileId = ?");
				ps.setLong(1, id);
				rs = ps.executeQuery();
				while(rs.next()) {
					FileStatistic fs = new FileStatistic();
					fs.setId(rs.getLong("id"));
					fs.setFileId(rs.getLong("fileId"));
					fs.setLongWord(rs.getString("longWord"));
					fs.setShortWord(rs.getString("shortWord"));
					fs.setRowLength(rs.getInt("rowsLength"));
					fs.setAvgRowLength(rs.getBigDecimal("avgRowLength"));
					list.add(fs);
				}
			}
		} catch (IOException | SQLException e) {
			LOG.log(Level.FINER, e.getMessage());
		} finally {
			try{
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(connect != null) {
				connect.close();
			}
		} catch(Exception e) {
			LOG.log(Level.FINER, e.getMessage());
		}
		}
		return list;
	}

	@Override
	public List<Statistic> getStatisticForFile() {
		List<Statistic> list = new ArrayList<>();
		PreparedStatement ps = null;
        ResultSet rs = null;
		try {
			connect = ConnectToDb.getConnection();
			if(connect != null) {
				ps = connect.prepareStatement("select id,longWord,shortWord,rowLength,avgRowLength from statistics");
				rs = ps.executeQuery();
				while(rs.next()) {
					Statistic fs = new Statistic();
					fs.setId(rs.getLong("id"));
					fs.setLongWord(rs.getString("longWord"));
					fs.setShortWord(rs.getString("shortWord"));
					fs.setRowLength(rs.getInt("rowsLength"));
					fs.setAvgRowLength(rs.getBigDecimal("avgRowLength"));
					list.add(fs);
				}
			}
		} catch (IOException | SQLException e) {
			LOG.log(Level.FINER, e.getMessage());
		} finally {
			try{
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(connect != null) {
				connect.close();
			}
		} catch(Exception e) {
			LOG.log(Level.FINER, e.getMessage());
		}
		}
		return list;
	}

	//For insert multiple records we can use batchUpdate
	@Override
	public void addFilesStatistic(FileStatistic fs) {
		PreparedStatement ps = null;
		try {
			connect = ConnectToDb.getConnection();
			if(connect != null) {
				connect.setAutoCommit(false);
				ps = connect.prepareStatement("insert into fileStatistics(fileId, longWord, "
						+ "shortWord, rowsLength, avgRowLength) "
						+ "values (?,?,?,?,?)");
				ps.setLong(1, fs.getFileId());
				ps.setString(2, fs.getLongWord());
				ps.setString(3, fs.getShortWord());
				ps.setInt(4, fs.getRowLength());
				ps.setBigDecimal(5, fs.getAvgRowLength());
				ps.executeUpdate();
				connect.commit();
			}
		} catch (IOException | SQLException e) {
		}	finally {
			try{
				if(ps != null) {
					ps.close();
				}
				if(connect != null) {
					connect.close();
				}
			} catch(Exception e) {
				LOG.log(Level.FINER, e.getMessage());
			}
		}
	}

	@Override
	public void addStatisticForFile(Statistic s) {
		PreparedStatement ps = null;
		try {
			connect = ConnectToDb.getConnection();
			if(connect != null) {
				connect.setAutoCommit(false);
				ps = connect.prepareStatement("insert into statistics(fileName, longWord, "
						+ "shortWord, rowsLength, avgRowLength) "
						+ "values (?,?,?,?,?)");
				ps.setString(1, s.getFileName());
				ps.setString(2, s.getLongWord());
				ps.setString(3, s.getShortWord());
				ps.setInt(4, s.getRowLength());
				ps.setBigDecimal(5, s.getAvgRowLength());
				ps.executeUpdate();
				connect.commit();
			}
		} catch (IOException | SQLException e) {
		}	finally {
			try{
				if(ps != null) {
					ps.close();
				}
				if(connect != null) {
					connect.close();
				}
			} catch(Exception e) {
				LOG.log(Level.FINER, e.getMessage());
			}
		}
	}

}