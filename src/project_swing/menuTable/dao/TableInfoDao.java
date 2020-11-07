package project_swing.menuTable.dao;

import java.util.List;

import project_swing.menuTable.dto.TableInfo;


public interface TableInfoDao {
	List<TableInfo> selectTableInfoByAll();

	int intsertTableInfo(TableInfo ti);
	
	int updateTableInfo(TableInfo ti);
	
	int deleteTableInfo(TableInfo ti);
	
	TableInfo selectTableInfoDaoByTableNo(TableInfo ti);
	

}
