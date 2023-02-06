package Dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.DbConnection;
import Model.member;

public class implMember implements memberDao{

	public static void main(String[] args) {
		//member m=new member("ABC","red","000","台北","44","123");
		
		//new implMember().add(m);
		//System.out.println(new implMember().queryAll1());
		/*List<member> l= new implMember().queryAll2();
		
		for(member o:l)
		{
			System.out.println(o.getId()+"\t"+o.getName());
		}
		System.out.println(l.size());//size()有幾個 */
		
		//System.out.println(new implMember().queryId(10));
		//System.out.println(new implMember().queryMember("uuu", "444"));
	
		/*member m =new implMember().queryId(5); //哪個表單，第幾列
		m.setPassword("878787"); //要修改的內容
		
		new implMember().update(m); //更新更改內容*/
		
		//new implMember().delete(10);
		
		System.out.println(new implMember().queryUser("abc"));

	}

	//新增資料
	@Override
	public void add(member m) {
		Connection conn=DbConnection.getDB(); //new DbConnecttion測試連線
		String sQL="insert into member(name,username,password,address,mobile,phone)"
					+"values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getMobile());
			ps.setString(6, m.getPhone());
			
			ps.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	//查詢資料(讀文字內容)
	@Override
	public String queryAll1() {
		Connection conn=DbConnection.getDB();
		String SQL="select * from member";
		String show="";//設定一個空字串，接收讀取的資料內容
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				//show+....之前的資料(show)，繼續接寫
				show=show+"id:"+rs.getInt("id")+
						"\t名:"+rs.getString("name")+
						"\t帳號:"+rs.getString("username")+
						"\t密碼:"+rs.getString("password")+
						"\t地址:"+rs.getString("address")+
						"\t行動:"+rs.getString("mobile")+
						"\t電話:"+rs.getString("phone")+"\n";
				//將接收到的訊息，變成一長串String
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return show; //要return String，才讀的到資料
	}

	//查詢資料(讀table內容)
	@Override
	public List<member> queryAll2() {
		Connection conn=DbConnection.getDB();
		String SQL="select * from member";
		List<member> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				member m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));
				l.add(m);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}

	//查詢id
	@Override
	public member queryId(int id) {
		/*
		 * 1.先連線->Connection
		 * 2.SQL語法-->where id=?
		 * 3.ResultSet(查詢結果)
		 * 4.if->rs.next()
		 * 5.true-->rs-->new member() (查詢有結果，顯示出查詢結果)
		 * 6.false-->null (查詢無結果，顯示null)
		 */
		
		Connection conn=DbConnection.getDB();
		String SQL="select *from member where id=?";
		member m=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m;
	}
	
	//查詢username, password
	@Override
	public member queryMember(String username, String password) {
		/*
		 * 1.先連線-->Connection
		 * 2.SQL-->where username=? and password=?
		 * 3.if(rs.next())
		 * 4.true--->new member()-->rs填入
		 * 5.false-->null
		 */
		
		Connection conn=DbConnection.getDB();
		String SQL="select *from member where username=? and password=?";
		member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,username); //給SQL查詢命令:第幾個問號，欄位名稱
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	
	//更新修改資料
	@Override
	public void update(member m) {
		/*
		 * 1.先連線
		 * 2.SQL-->update 全部內容 where id=?
		 * 3.preparedStatement執行
		 */
		
		//Step01
		Connection conn=DbConnection.getDB();
		//Step02
		String SQL="update member set name=?,username=?,password=?,address=?,mobile=?,phone=?"+
					"where id=?";
		
		try {
			//Step03
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, m.getName());//告訴SQL第幾個問號，什麼欄位要取的新內容
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getMobile());
			ps.setString(6, m.getPhone());
			ps.setInt(7, m.getId());
			
			ps.executeUpdate();//執行內容更新
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	//刪除資料
	@Override
	public void delete(int id) {
		/*
		 * 1.連線
		 * 2.sql-->where id=?
		 * 3.prep-->執行 
		 */
		
		//Step01
		Connection conn=DbConnection.getDB();
		//Step02
		String SQL="delete from member where id=?";
		//Step03
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//判定有無相同username
	@Override
	public boolean queryUser(String username) {
		Connection conn=DbConnection.getDB();
		String SQL="select *from member where username=?";
		boolean m =false;
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	
	
}
