package com.google.clone.util;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.clone.dao.CloneDao;
import com.google.clone.model.InformationModel;

public class Helper {
	
	private static Document doc = null;
	
	private final Logger logger = Logger
			.getLogger(Helper.class.getSimpleName());
	
	private static final ThreadLocal<Integer> threadLocalCount = new  ThreadLocal<Integer>();
	
	@Autowired
	private CloneDao cloneDao;
	
	public void setCloneDao(CloneDao cloneDao) {
		this.cloneDao = cloneDao;
	}
	
	public void getInfo(String url) {
		if(threadLocalCount.get() == null) {
			threadLocalCount.set(0);
		}
		try {
			Set<String> set = getUrls(url);
			cloneDao.saveToDb(url, getKeywords(url));
			if(set != null && set.size() != 0) {
				if(threadLocalCount.get().compareTo(Integer.valueOf(3)) == -1) {
				Iterator iter = set.iterator();
				while(iter.hasNext()) {
					String urlNew = (String)iter.next();
					if(urlNew != null && !urlNew.isEmpty()) {
						getInfo(urlNew);
					}
					threadLocalCount.set(threadLocalCount.get()+1);
				}
			}
			}
		} catch(Exception e) {
			logger.log(Level.FINE, e.getMessage());
		}
	}
	
	private Set<String> getUrls(String url) throws IOException {
		Set<String> set = new HashSet<>();
		doc = Jsoup.connect(url).get();
		Elements links = doc.select("a");
		for (Element el : links) {
			set.add(el.attr("href"));
		}
		return set;
	}
	
	private static String getKeywords(String url) throws IOException {
		StringBuilder sb = new StringBuilder();
		doc = Jsoup.connect(url).get();
		Elements keywords = doc.select("meta");
		for(Element el : keywords) {
			if(el.attr("name").equals("description") || el.attr("name").equals("keywords")) {
				sb.append(el.attr("content"));
			}
		}
		return sb.toString();
	}
	
	public List<InformationModel> getFullInfo(String key) {
		return cloneDao.getInfo(key);
	}
}