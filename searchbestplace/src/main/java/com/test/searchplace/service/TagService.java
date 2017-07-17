package com.test.searchplace.service;

import java.util.List;

import com.test.searchplace.model.Tag;

public interface TagService {
	void createTag(Tag tag);
	List<Tag> getTags(String name);
	void updateTag(Tag tag);
	void deleteTag(Tag tag);
}