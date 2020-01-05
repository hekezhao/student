package dao;

import java.sql.*;
import java.util.ArrayList;

import bean.Inform;

public class InformDao extends BaseDao {
	//按学号检索通知
	public ArrayList<Inform> findBySno(String sno) {
		String sql="SELECT * FROM infrom "+
				"WHERE userno=? "+
				"ORDER BY send_time DESC";
		ArrayList<Inform> informList=new ArrayList<Inform>();
		try(
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setString(1, sno);
			try(ResultSet rst=pstmt.executeQuery()) {
				while(rst.next()) {
					Inform inform=new Inform();
					inform.setSno(rst.getString("userno"));
					inform.setSendTime(rst.getTimestamp("send_time"));
					inform.setTitle(rst.getString("title"));
					inform.setTxt(rst.getString("txt"));
					inform.setType(rst.getInt("type"));
					informList.add(inform);
				}
				conn.close();
				return informList;
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//检索一个具体的通知
	public Inform findSpecificInform(String sno,Timestamp sendTime) {
		String sql="SELECT * FROM infrom "+
				"WHERE userno=? AND send_time=?";
		Inform inform=new Inform();
		try(
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setString(1, sno);
			pstmt.setTimestamp(2, sendTime);
			try(ResultSet rst=pstmt.executeQuery()) {
				if(rst.next()) {
					inform.setSno(rst.getString("userno"));
					inform.setSendTime(rst.getTimestamp("send_time"));
					inform.setTitle(rst.getString("title"));
					inform.setTxt(rst.getString("txt"));
					inform.setType(rst.getInt("type"));
				}
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return inform;
	}
}
