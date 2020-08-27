package web_study_09.ds;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

public class JdbcUtilJNDITest {

	 @Test
	    public void testGetConnection() {
	        System.out.println("testGetConnection()");
	        Connection con = JdbcUtil.getConnection();
	        Assert.assertNotNull(con);
	        System.out.println("con : " + con);
}
}
