package project_swing.menuTable.dao;

import java.util.List;

import project_swing.menuTable.dto.MenuOrder;
import project_swing.menuTable.dto.TableInfo;

public interface MenuOrderDao {
	List<MenuOrder> selectMenuOrderByAll();	
	
	  int insertMeunOrder(MenuOrder mo);
	  
	  int deleteMenuOrder(MenuOrder mo);
	  
	  int updateMenuOrder(MenuOrder mo);	 
	
	List<MenuOrder> selectOrderByTableNo(TableInfo tInfo);

}
