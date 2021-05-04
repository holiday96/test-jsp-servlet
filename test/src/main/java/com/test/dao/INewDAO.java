package com.test.dao;

import java.util.List;

import com.test.model.NewModel;
import com.test.paging.Pageble;

public interface INewDAO extends GenericDAO<NewModel> {
	NewModel findOne(Long id);
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
	void update(NewModel updateNew);
	void delete(Long id);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
}
