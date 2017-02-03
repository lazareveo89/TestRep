package com.test.searchplace.dao;

import java.util.List;

import com.test.searchplace.model.Tag;

public interface TagDao {
	void createTag(Tag tag);
	List<Tag> getTags(String name);
	void updateTag(Tag tag);
	void deleteTag(Tag tag);
}