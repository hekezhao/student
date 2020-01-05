package dao;

import java.sql.*;
import java.util.ArrayList;

import bean.Class;

public class ClassDao extends BaseDao {
	//°´Ñ§ºÅ¼ìË÷¿Î³Ì
	public ArrayList<Class> findBySno(String sno) {
		String sql="SELECT teach.cno,cname,teach.term,sno,teach.tno,tname "+
				"FROM teach,class,teacher "+
				"WHERE sno=? AND teach.cno=class.cno AND teach.term=class.term AND teach.tno=teacher.tno";
		ArrayList<Class> classList=new ArrayList<Class>();
		try(
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setString(1, sno);
			try(ResultSet rst=pstmt.executeQuery()) {
				while(rst.next()) {
					Class cla=new Class();
					cla.setCno(rst.getString("cno"));
					cla.setCname(rst.getString("cname"));
					cla.setTerm(rst.getString("term"));
					cla.setSno(rst.getString("sno"));
					cla.setTno(rst.getString("tno"));
					cla.setTname(rst.getString("tname"));
					classList.add(cla);
				}
				conn.close();
				return classList;
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
