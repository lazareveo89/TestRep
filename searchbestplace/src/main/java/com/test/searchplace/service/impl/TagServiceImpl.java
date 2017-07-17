package com.test.searchplace.service.impl;

import com.test.searchplace.dao.TagDao;
import com.test.searchplace.model.Tag;
import com.test.searchplace.service.List;
import com.test.searchplace.service.String;
import com.test.searchplace.service.TagService;

import org.springframework.beans.factory.annotation.Autowired;

public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;
    
    @Override
    public void createTag(Tag tag) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public List getTags(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void updateTag(Tag tag) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void deleteTag(Tag tag) {
	// TODO Auto-generated method stub
	
    }
    
    public TagDao getTagDao() {
	return tagDao;
    }

}
