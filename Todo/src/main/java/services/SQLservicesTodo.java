package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Person;
import model.ToDoBean;
import util.DbUtil;

public class SQLservicesTodo {
	private ResultSet rs;
	ArrayList<ToDoBean> list = new ArrayList<ToDoBean>();
	

	public ArrayList<ToDoBean> selectAll() {
		String sql = "SELECT id, title, priority,DATE_FORMAT(term, '%Y/%m/%d')AS term, contents,done from todo ORDER BY term";

		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			// PreparedStatementがクローズされるタイミングでクローズされる
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String priority = rs.getString("priority");
				String term = rs.getString("term");
				String contents = rs.getString("contents");
				String done = rs.getString("done");
				list.add(new ToDoBean(id, title, priority, term,
						contents, done));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<ToDoBean> selectAllDesc() {
		String sql = "SELECT id, title, priority,DATE_FORMAT(term,'%Y/%m/%d')AS term, contents,done from todo \n"
				+ "ORDER BY term desc;";

		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			// PreparedStatementがクローズされるタイミングでクローズされる
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String priority = rs.getString("priority");
				String term = rs.getString("term");
				String contents = rs.getString("contents");
				String done = rs.getString("done");
				list.add(new ToDoBean(id, title, priority, term,
						contents, done));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//where athlete_id
	public void insert(String title, String priority, String term, String contents) {
		String sql = "insert into ToDo(title,priority,term,contents) values(?, ?, ?, ?)";
		try (Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, title);
			ps.setString(2, priority);
			ps.setString(3, term);
			ps.setString(4, contents);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ToDoBean> selectAllDelay() {
		String sql = "SELECT id, title, priority,DATE_FORMAT(term, '%Y/%m/%d')AS term,  contents,done  from todo WHERE term < CURDATE() AND done =\"未完了\" ORDER BY term;";

		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			// PreparedStatementがクローズされるタイミングでクローズされる
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String priority = rs.getString("priority");
				String term = rs.getString("term");
				String contents = rs.getString("contents");
				String done = rs.getString("done");
				list.add(new ToDoBean(id, title, priority, term,
						contents, done));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void update(int done_id) {
		String sql = "UPDATE todo SET done = \"完了\" WHERE id = ?;";
		try (Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, done_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int delete_id) {
		String sql = "DELETE FROM todo WHERE id = ?";
		try (Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, delete_id);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ToDoBean> selectAllDone() {
		String sql = "SELECT id, title, priority,DATE_FORMAT(term, '%Y/%m/%d')AS term,  contents,done  from todo WHERE done =\"完了\" ORDER BY term;";

		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			// PreparedStatementがクローズされるタイミングでクローズされる
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String priority = rs.getString("priority");
				String term = rs.getString("term");
				String contents = rs.getString("contents");
				String done = rs.getString("done");
				list.add(new ToDoBean(id, title, priority, term,
						contents, done));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public void update_id(int afterEdit_id, String title,String priority, String term, String contents) {
		String sql = "UPDATE todo SET title=?, priority=?, term=?,contents=? WHERE id = ?;";
		try (Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, title);
			ps.setString(2,priority);
			ps.setString(3, term);
			ps.setString(4, contents);
			ps.setInt(5, afterEdit_id);
			//System.out.println(title+priority+term+contents);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ToDoBean select_EditID(int edit_id) {
		String sql = "SELECT id, title, priority,DATE_FORMAT(term, '%Y/%m/%d')AS term, contents,done from todo WHERE id = ?;";
		ToDoBean lists = null;
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			// PreparedStatementがクローズされるタイミングでクローズされる
			ps.setInt(1, edit_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String priority = rs.getString("priority");
				String term = rs.getString("term");
				String contents = rs.getString("contents");
				String done = rs.getString("done");
				lists = new ToDoBean(id, title, priority, term,
						contents, done);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}
	public Person Login(String names, String mails, String passwords) {
		String sql = "SELECT * FROM todousers WHERE NAME = ? AND mail = ? AND pass = ?;";
		Person person = null;
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			// PreparedStatementがクローズされるタイミングでクローズされる
			ps.setString(1, names);
			ps.setString(2, mails);
			ps.setString(3, passwords);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String password = rs.getString("pass");
				
				person = new Person(id, name, mail, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}
	

}
