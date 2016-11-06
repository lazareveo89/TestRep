package com.test.filestatistics.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.test.filestatistics.dao.FileStatisticDao;
import com.test.filestatistics.model.FileInfo;
import com.test.filestatistics.model.Statistic;
import com.test.filestatistics.util.ConnectToDb;

public class FileStatisticDaoImpl implements FileStatisticDao {

	private static String sqlScript = "insert into statistics(fileName, rowNum, longWord, "
			+ "shortWord, lengthRow, avgLengthRow) values(?,?,?,?,?,?)";

	public void saveStatistic(FileInfo fileInfo) {
		Connection connection = null;
		PreparedStatement ps = null;
		Statistic stat = fileInfo.getFileStatistics();
		try {
			connection = ConnectToDb.getConnection();
			if (connection != null) {
				connection.setAutoCommit(false);
				ps = connection.prepareStatement(sqlScript);
				ps.setString(1, stat.getFileName());
				ps.setInt(2, stat.getRowNum());
				ps.setString(3, stat.getLongWord());
				ps.setString(4, stat.getShortWord());
				ps.setInt(5, stat.getLengthRow());
				ps.setBigDecimal(6, stat.getAvgLengthRow());
				ps.executeUpdate();
				List<Statistic> list = fileInfo.getListRowStatistics();
				for(Statistic s : list) {
					ps.setString(1, stat.getFileName());
					ps.setInt(2, s.getRowNum());
					ps.setString(3, s.getLongWord());
					ps.setString(4, s.getShortWord());
					ps.setInt(5, s.getLengthRow());
					ps.setBigDecimal(6, s.getAvgLengthRow());
					ps.executeUpdate();
					connection.commit();
				}
			}
		} catch (IOException | SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			System.err.println(e.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}

	}
}