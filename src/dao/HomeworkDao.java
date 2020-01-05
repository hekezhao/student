package dao;

import java.sql.*;
import java.util.ArrayList;

import bean.Homework;

public class HomeworkDao extends BaseDao {
	//按学习课程检索作业
	public ArrayList<Homework> find(String cno,String term,String sno,String tno) {
		String sql="SELECT * FROM homework "+
				"WHERE cno=? AND term=? AND sno=? AND tno=?";
		ArrayList<Homework> homeworkList=new ArrayList<Homework>();
		try(
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setString(1, cno);
			pstmt.setString(2, term);
			pstmt.setString(3, sno);
			pstmt.setString(4, tno);
			try(ResultSet rst=pstmt.executeQuery()) {
				while(rst.next()) {
					Homework homework=new Homework();
					homework.setCno(rst.getString("cno"));
					homework.setTerm(rst.getString("term"));
					homework.setSno(rst.getString("sno"));
					homework.setTno(rst.getString("tno"));
					homework.setBeginTime(rst.getTimestamp("begintime"));
					homework.setEndTime(rst.getTimestamp("endtime"));
					homework.setTitle(rst.getString("title"));
					homework.setTxt(rst.getString("txt"));
					homework.setAnswer(rst.getString("answer"));
					homework.setReply(rst.getString("reply"));
					homework.setScore(rst.getDouble("score"));
					homework.setFilepath(rst.getString("filepath"));
					homeworkList.add(homework);
				}
				conn.close();
				return homeworkList;
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//检索一个具体的作业
	public Homework findSpecificHomework(String cno,String term,String sno,String tno,String title) {
		String sql="SELECT * FROM homework "+
				"WHERE cno=? AND term=? AND sno=? AND tno=? AND title=?";
		Homework homework=new Homework();
		try(
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setString(1, cno);
			pstmt.setString(2, term);
			pstmt.setString(3, sno);
			pstmt.setString(4, tno);
			pstmt.setString(5, title);
			try(ResultSet rst=pstmt.executeQuery()) {
				if(rst.next()) {
					
					homework.setCno(rst.getString("cno"));
					homework.setTerm(rst.getString("term"));
					homework.setSno(rst.getString("sno"));
					homework.setTno(rst.getString("tno"));
					homework.setBeginTime(rst.getTimestamp("begintime"));
					homework.setEndTime(rst.getTimestamp("endtime"));
					homework.setTitle(rst.getString("title"));
					homework.setTxt(rst.getString("txt"));
					homework.setAnswer(rst.getString("answer"));
					homework.setReply(rst.getString("reply"));
					homework.setScore(rst.getDouble("score"));
					homework.setFilepath(rst.getString("filepath"));
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
		return homework;
	}
	
	//更新作业答案和存储路径
	public boolean updateAnswer(Homework homework) {
		String sql="UPDATE homework SET "+
				"answer=?,filepath=? "+
				"WHERE cno=? AND term=? AND sno=? AND tno=? AND title=?";
		try(
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setString(1, homework.getAnswer());
			pstmt.setString(2, homework.getFilepath());
			pstmt.setString(3, homework.getCno());
			pstmt.setString(4, homework.getTerm());
			pstmt.setString(5, homework.getSno());
			pstmt.setString(6, homework.getTno());
			pstmt.setString(7, homework.getTitle());
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
