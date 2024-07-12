package com.ycw.dao;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import com.ycw.bean.AirBean;

public interface AirDao {
	int getInsert(AirBean airQuality) throws SQLException;
	int getDelete(int id) throws SQLException;
	void doTruncate() throws SQLException;
	int getUpdate(AirBean airQuality) throws SQLException;
	AirBean getOne(int id) throws SQLException;
	List<String> getAllAreas() throws SQLException;
	List<AirBean> getArea(String area) throws SQLException;
	List<AirBean> getAll() throws SQLException;
	
	// 添加分頁方法
    List<AirBean> getAllPaged(int offset, int limit) throws SQLException;
    int getTotalCount() throws SQLException;
}
