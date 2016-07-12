package com.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import com.test.model.FileStatistic;
import com.test.model.Statistic;
import com.test.util.FileUtil;

@RunWith(EasyMockRunner.class)
public class TestDao {
    
    @Mock
    private FileStatisticDao fileDao;
    
    @After
    public void tearDown() throws Exception {
	reset(fileDao);
    }
    
    	private List<String[]> list = FileUtil.parseUtil("./files/sputnik.txt");
	private List<Statistic> list2 = FileUtil.getStatisticForFile(list);
	private List<FileStatistic> list3 = FileUtil.getFileStatistic(list2);
    
    @Test
    public void test_execute_A$Execution() {
	
	if(list2 != null && !list2.isEmpty()) {
	for(Statistic tf : list2) {
	    fileDao.addStatisticForFile(tf);
	}
}
	if(list3 != null && !list3.isEmpty()) {
	for(FileStatistic fs : list3){
	    fileDao.addFilesStatistic(fs);
	}
}
	
	List<FileStatistic> listStat = new ArrayList<FileStatistic>();
	expect(fileDao.getFilesStatistic(list3.get(0).getId())).andReturn(listStat);
	
	List<Statistic> listRowStat = new ArrayList<Statistic>();
	expect(fileDao.getStatisticForFile()).andReturn(listRowStat);
	
	replay(fileDao);
	try {
	    verify(fileDao);
	} catch (Exception e) {
	    fail();
	}
    }    
}