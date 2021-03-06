package project_swing.menuTable.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_swing.conn.JdbcUtil;
import project_swing.menuTable.dao.MenuDao;
import project_swing.menuTable.dto.Menu;

public class MenuDaoImpl implements MenuDao {
	private static final MenuDaoImpl instance = new MenuDaoImpl();

	private MenuDaoImpl() {
	}

	public static MenuDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Menu> selectMenuByMenu(String type) {		
		String sql = "SELECT CODE, NAME, PRICE FROM MENU WHERE SUBSTR(CODE,1,1) = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, type);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					List<Menu> list = new ArrayList<Menu>();
					do {
						list.add(getMenu(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Menu getMenu(ResultSet rs) throws SQLException {
		String code = rs.getString("CODE");
		String name = rs.getString("NAME");
		int price = rs.getInt("PRICE");
		return new Menu(code, name, price);
	}

	@Override
	public int intsertMenu(Menu m) {
		String sql = "INSERT INTO MENU VALUES(?, ?, ?)";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, m.getCode());
			pstmt.setString(2, m.getName());
			pstmt.setInt(3, m.getPrice());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateMenu(Menu m) {
		String sql = "UPDATE MENU SET NAME = ?, PRICE = ? WHERE CODE = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, m.getName());
			pstmt.setInt(2, m.getPrice());
			pstmt.setString(3, m.getCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int deleteMenu(Menu fd) {
		String sql = "DELETE FROM MENU WHERE CODE = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, fd.getCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Menu selectMenuByMenuCode(Menu m) {
		String sql = "SELECT CODE, NAME, PRICE FROM MENU WHERE CODE = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, m.getCode());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getMenu(rs);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

}
