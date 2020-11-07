package project_swing.menuTable.dao;

import java.util.List;

import project_swing.menuTable.dto.Menu;

public interface MenuDao {
	List<Menu> selectMenuByMenu(String type);
	
	int intsertMenu(Menu m);
	
	int updateMenu(Menu m);
	
	int deleteMenu(Menu m);
	
	Menu selectMenuByMenuCode(Menu m);

}
