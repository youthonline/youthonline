package com.photos.dao;

import java.util.List;

import com.photos.model.Activity;

public interface ActivityDAO {
	
	public Boolean addActivity(Activity activity);
	
	public Boolean deleteActivity(Activity activity);
	
	public Boolean deleteById(int actid);
	
	public Boolean update(Activity activity);
	
	public List<Activity> queryAll();

	public Activity queryById(int id);
	
	public Activity queryByName(String actName);
	
	public int queryCount();
	
}
