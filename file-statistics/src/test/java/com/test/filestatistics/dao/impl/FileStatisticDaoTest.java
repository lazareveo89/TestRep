package com.test.filestatistics.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.test.filestatistics.dao.FileStatisticDao;
import com.test.filestatistics.model.FileInfo;
import com.test.filestatistics.model.Statistic;
import com.test.filestatistics.service.FileStatisticService;
import com.test.filestatistics.service.impl.FileStatisticServiceImpl;
import com.test.filestatistics.util.ConnectToDb;

public class FileStatisticDaoTest {
//Подумать и сделать
	private String fileName = "./file/test.txt";
	private FileStatisticService fss = new FileStatisticServiceImpl();
	private FileStatisticDao fsd = new FileStatisticDaoImpl();
	private Connection conn = null;
	private PreparedStatement ps = null;
	private String sqlScript = "insert into statistics(fileName, rowNum, longWord, "
			+ "shortWord, lengthRow, avgLengthRow) " + "values(?,?,?,?,?,?)";

	@Before
	public void setupDB() {
		try {
			conn = ConnectToDb.getConnection();
		} catch (SQLException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@After
	public void tearDown() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertDataForFile() {
		try {
			ps = conn.prepareStatement(sqlScript);
			conn.setAutoCommit(false);
			FileInfo fi = fss.getFileStatistic(fileName);
			
			ps.setString(1, fi.getFileStatistics().getFileName());
			ps.setInt(2, fi.getFileStatistics().getRowNum());
			ps.setString(3, fi.getFileStatistics().getLongWord());
			ps.setString(4, fi.getFileStatistics().getShortWord());
			ps.setInt(5, fi.getFileStatistics().getLengthRow());
			ps.setBigDecimal(6, fi.getFileStatistics().getAvgLengthRow());
			int i = ps.executeUpdate();
			conn.rollback();
			//fsd.saveStatistic(fi);
			assertTrue(i==1);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}
	@Test
	public void testInsertDataForRows() {
		try {
			ps = conn.prepareStatement(sqlScript);
			conn.setAutoCommit(false);
			FileInfo fi = fss.getFileStatistic(fileName);
			int i = 0;
			List<Statistic> list = fi.getListRowStatistics();
			for(Statistic s : list) {
				ps.setString(1, fi.getFileStatistics().getFileName());
				ps.setInt(2, s.getRowNum());
				ps.setString(3, s.getLongWord());
				ps.setString(4, s.getShortWord());
				ps.setInt(5, s.getLengthRow());
				ps.setBigDecimal(6, s.getAvgLengthRow());
				i += ps.executeUpdate();
				conn.rollback();
			}
			assertTrue(i==40);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}
}
