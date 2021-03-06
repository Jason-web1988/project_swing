package project_swing.menuTable.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project_swing.conn.JdbcUtil;
import project_swing.menuTable.dao.MenuOrderDao;
import project_swing.menuTable.dto.Menu;
import project_swing.menuTable.dto.MenuOrder;
import project_swing.menuTable.dto.TableInfo;

public class MenuOrderDaoImpl implements MenuOrderDao {
	private static final MenuOrderDaoImpl instance = new MenuOrderDaoImpl();

	private MenuOrderDaoImpl() {
	}

	public static MenuOrderDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<MenuOrder> selectMenuOrderByAll() {
		String sql = "SELECT o.NO NO, o.CODE CODE, ORDERDAY, CNT, ISPAYMENT, m.NAME MNANE, PRICE, t.NAME TNAME FROM MENU_ORDER o JOIN MENU m ON o.CODE = m.CODE JOIN TABLEINFO t ON o.NO = t.NO";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<MenuOrder> list = new ArrayList<MenuOrder>();
				do {
					list.add(getMenuOrder(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



//	@Override
//	public int insertMeunOrder(MenuOrder mo) {
//		String sql = "INSERT INTO MENU_ORDER VALUES(?, ?, ?, ?, ?)";
//		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
//			pstmt.setInt(1, mo.getTableInfo().getNo());
//			pstmt.setString(2, mo.getMenu().getCode());
//			pstmt.setTimestamp(3, new Timestamp(mo.getOrderday().getTime()));
//			pstmt.setInt(4, mo.getCnt());
//			pstmt.setInt(5, mo.getIsPayment());
//			return pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}

	@Override
	public int insertMeunOrder(MenuOrder mo) {
		System.out.println("mo~~~~~ : " + mo);
		String sql = "INSERT INTO MENU_ORDER VALUES(?, ?, ?, ?, ?)";
		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			System.out.println("테이블번호 : " +  mo.getTableInfo().getNo());
			System.out.println("메뉴코드 : " + mo.getMenu().getCode());
			System.out.println("주문일자 : " + new Timestamp(mo.getOrderday().getTime()));
			System.out.println("갯수 : " + mo.getCnt());
			System.out.println("결재여부 : " + mo.getIsPayment());
			
			pstmt.setInt(1, mo.getTableInfo().getNo());
			pstmt.setString(2, mo.getMenu().getCode());
			pstmt.setTimestamp(3, new Timestamp(mo.getOrderday().getTime()));
			pstmt.setInt(4, mo.getCnt());
			pstmt.setInt(5, mo.getIsPayment());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int deleteMenuOrder(MenuOrder mo) {
		String sql = "DELETE FROM MENU_ORDER WHERE NO = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, mo.getTableInfo().getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException ee) {
			ee.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateMenuOrder(MenuOrder mo) {
		String sql = "UPDATE MENU_ORDER SET ISPAYMENT=? WHERE NO =?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
//			pstmt.setString(1, mo.getMenu().getCode());
//			System.out.println("1 : " + mo.getMenu().getCode());
//			
//			pstmt.setTimestamp(2, new Timestamp(mo.getOrderday().getTime()));
//			System.out.println("2 : " + mo.getOrderday().getTime());
//			
//			pstmt.setInt(3, mo.getCnt());
//			System.out.println("3 : " + mo.getCnt());
//			
			pstmt.setInt(1, mo.getIsPayment());
			System.out.println("4 : " + mo.getIsPayment());
			
			pstmt.setInt(2, mo.getTableInfo().getNo());
			System.out.println("5 : " + mo.getTableInfo().getNo());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	private MenuOrder getMenuOrder(ResultSet rs) throws SQLException {
		TableInfo tableInfo = new TableInfo(rs.getInt("NO"), rs.getString("TNAME"));
		Menu menu = new Menu(rs.getString("CODE"), rs.getString("MNANE"), rs.getInt("PRICE"));
		System.out.println(menu.getCode() + " " + menu.getName() + " " + menu.getPrice());
		Date orderDay = rs.getTimestamp("ORDERDAY");
		int cnt = rs.getInt("CNT");
		int isPayment = rs.getInt("ISPAYMENT");
		return new MenuOrder(tableInfo, menu, orderDay, cnt, isPayment);
	}
	
	@Override
	public List<MenuOrder> selectOrderByTableNo(TableInfo tInfo) {
		String sql = "SELECT o.NO AS NO, o.CODE AS CODE, ORDERDAY, CNT, ISPAYMENT, m.NAME AS MNANE, PRICE, t.NAME AS TNAME FROM MENU_ORDER o JOIN MENU m ON o.CODE = m.CODE JOIN TABLEINFO t ON o.NO = t.NO WHERE o.NO = ? AND ISPAYMENT = 0";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, tInfo.getNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					List<MenuOrder> list = new ArrayList<MenuOrder>();
					do{
						list.add(getMenuOrder(rs));
					}while(rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	// List가 아니라 MenuOrder 하나만 리턴.
//	@Override
//	public MenuOrder selectByOrderNo(MenuOrder mo) {
//		String sql = "SELECT * " + "FROM MENU_ORDER WHERE NO = ?";
//		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
//			pstmt.setInt(1, mo.getTno().getNo());
//			try (ResultSet rs = pstmt.executeQuery()) {
//				if (rs.next()) {
//					return getMenuOrder(rs);
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
