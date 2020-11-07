package project_swing.conn;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import project_swing.conn.JdbcUtil;

public class JdbcUtilTest {

	@Test
	public void testGetConnection() {
		Connection con = JdbcUtil.getConnection();
		Assert.assertNotNull(con);
		System.out.println(con);
	}

}
