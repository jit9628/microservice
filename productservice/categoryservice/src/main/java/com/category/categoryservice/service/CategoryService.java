package com.category.categoryservice.service;

import java.util.List;

import com.category.categoryservice.entity.Category;

public interface CategoryService {
	public String addCategory(Category category);

	public List<Category> fetchAllCategory();
}
