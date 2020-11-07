package project_swing.menuTable.dao.Impl.service;

import java.util.List;

import project_swing.menuTable.dao.MenuDao;
import project_swing.menuTable.dao.Impl.MenuDaoImpl;
import project_swing.menuTable.dto.Menu;

public class MenuService {
	private MenuDao dao = MenuDaoImpl.getInstance();
	
	public List<Menu> getMenuList(String type){
		return dao.selectMenuByMenu(type);	
	}
	
//	public void addMenuOrder(MenuOrder mo) {
//		dao.insertMeunOrder(mo);
//	}
//	
//	public void removeMainFood(MenuOrder mo) {
//		dao.deleteMenuOrder(mo);
//	}

}
