package com.test.filestatistics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.filestatistics.model.FileInfo;
import com.test.filestatistics.service.FileStatisticService;

@RestController
public class FileStatisticController {
	@Autowired
	private FileStatisticService fileStatisticService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage() {
        return "index";
    }
	
	@RequestMapping(value = "/getStatistics", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody List<FileInfo> getFilesStatistics() {
		return getFileStatisticService().getFilesStatistics();
	}
	
	public FileStatisticService getFileStatisticService() {
		return fileStatisticService;
	}
}
