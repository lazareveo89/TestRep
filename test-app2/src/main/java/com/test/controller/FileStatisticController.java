package com.test.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.dao.FileStatisticDao;
import com.test.model.FileStatistic;
import com.test.model.Statistic;
import com.test.util.FileUtil;

@Controller
@RequestMapping(value="/")
public class FileStatisticController {
	
	@Autowired
	private FileStatisticDao fileDao;
	
	/**
	 * 
	 * Статистика общая
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/allStat", method = RequestMethod.GET)
	public ModelAndView getFilesStatistic() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("filesStatistic", getFileDao().getFilesStatistic());
		return mav;
	}
	/**
	 * Статистика по файлу
	 * @param id
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/fileId", method = RequestMethod.GET)
	public ModelAndView getStatisticForFile(@RequestParam(value = "id") Long id) {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("filesStatistic", getFileDao().getStatisticForFile(id));
		return mav;
	}
	
	/**
	 * 
	 * Добавить статистику по файлу
	 * @param pathToFile
	 */
	@RequestMapping(value = "/addAllStatistic", method = RequestMethod.POST)
	public void addStatisticForFile(@RequestParam(value = "pathToFile") String pathToFile) {
		List<String[]> list = FileUtil.parseUtil(pathToFile);
		List<Statistic> list2 = FileUtil.getStatisticForFile(list);
		List<FileStatistic> list3 = FileUtil.getFileStatistic(list2);
		for(FileStatistic fs : list3){
			getFileDao().addFilesStatistic(fs);
		}
		for(Statistic s : list2) {
			getFileDao().addStatisticForFile(s);
		}
	}
	
	public FileStatisticDao getFileDao() {
		return fileDao;
	}
}