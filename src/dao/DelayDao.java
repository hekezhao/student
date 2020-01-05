package dao;

import java.sql.*;

import bean.Delay;

public class DelayDao extends BaseDao {
	//插入一条延期申请记录
	public boolean addDelay(Delay delay) {
		String sql="INSERT INTO delay "+
				"(cno,term,sno,tno,sendTime,workTitle,reason,delayDays) "+
				"VALUES (?,?,?,?,NOW(),?,?,?)";
		try(
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setString(1, delay.getCno());
			pstmt.setString(2, delay.getTerm());
			pstmt.setString(3, delay.getSno());
			pstmt.setString(4, delay.getTno());
			pstmt.setString(5, delay.getWorkTitle());
			pstmt.setString(6, delay.getReason());
			pstmt.setString(7, delay.getDelayDays());
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
