package Dao.porder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.DbConnection;
import Model.porder;

public class implPorder implements porderDao{

	public static void main(String[] args) {
		//連線測試
		//System.out.println(porderDao.getdb());
		
		//add
		/*porder p=new porder("A桌",1,1,1);
		porder p1=new porder("B桌",2,1,1);
		porder p2=new porder("C桌",1,2,1);
		porder p3=new porder("D桌",1,2,2);
		porder p4=new porder("E桌",1,1,2);
		new implPorder().add(p);
		new implPorder().add(p1);
		new implPorder().add(p2);
		new implPorder().add(p3);
		new implPorder().add(p4);*/
		
		//查詢資料庫
		//System.out.println(new implPorder().selectAll());
		
		//資料庫內，搜尋id
		//System.out.println(new implPorder().selectId(5));
		
		//update更新點餐資訊
		/*porder p=new implPorder().selectId(2);
		p.setDesk("F桌");
		new implPorder().update(p);*/
		
		//delete
		new implPorder().delete(4);
	}

	//add
	@Override
	public void add(porder p) {
		Connection conn=DbConnection.getDB();//Connection可以寫在interface要java8之後
		String SQL="insert into porder(desk,A,B,C)"//SQL語法
				+"values(?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);//資料庫查詢命令語法(搭配set和get)
			ps.setString(1,p.getDesk());
			ps.setInt(2,p.getA());
			ps.setInt(3,p.getB());
			ps.setInt(4,p.getC());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	//read
	@Override
	public List<porder> selectAll() {
		Connection conn=DbConnection.getDB();
		String SQL="select * from porder";
		List<porder> l=new ArrayList();//建一個空List給ResultSet搜尋到資料後，儲存搜尋到的資料
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())//if(ResultSet游標功能搜尋表單，有搜尋到(true))
			{
				porder p1=new porder();
				p1.setId(rs.getInt("id"));
				p1.setDesk(rs.getString("desk"));
				p1.setA(rs.getInt("A"));
				p1.setB(rs.getInt("B"));
				p1.setC(rs.getInt("C"));
				
				l.add(p1);//加進List p1
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	//search id
	@Override
	public porder selectId(int id) {
		Connection conn=DbConnection.getDB();
		String SQL="select * from porder where id=?";
		porder p=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs= ps.executeQuery();//ResultSet游標位置=資料庫內搜尋到的每一格的資料
			
			if(rs.next())
			{
				p=new porder();
				p.setId(rs.getInt("id"));
				p.setDesk(rs.getString("desk"));
				p.setA(rs.getInt("A"));
				p.setB(rs.getInt("B"));
				p.setC(rs.getInt("C"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	//update
	@Override
	public void update(porder p) {
		Connection conn=DbConnection.getDB();
		String SQL="update porder set desk=?,A=?,B=?,C=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, p.getDesk());
			ps.setInt(2, p.getA());
			ps.setInt(3, p.getB());
			ps.setInt(4, p.getC());
			ps.setInt(5, p.getId());
			
			ps.executeUpdate();//executeUpdate()可支援insert/update/delect，必加(要執行搜尋)
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//delete
	@Override
	public void delete(int id) {
		Connection conn=DbConnection.getDB();
		String SQL="delete from porder where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
