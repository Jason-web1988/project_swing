package project_swing.menuTable.dao.Impl.service;

import java.util.List;

import project_swing.menuTable.dao.TableInfoDao;
import project_swing.menuTable.dao.Impl.TableInfoDaoImpl;
import project_swing.menuTable.dto.TableInfo;

public class TableInfoService {
	TableInfoDao dao = TableInfoDaoImpl.getInstance();
	
	public List<TableInfo> selectTableInfoAll() {
		return dao.selectTableInfoByAll();
	}
}
