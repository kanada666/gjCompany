package Dao.member;

import java.util.List;

import Model.member;

public interface memberDao {
	
	//Creat新增
	//void add(String name, String username, String password, String address, String phone, String mobile);
	void add(member m);//等於上面那一行(Line10)//inject 注入
	
	//read查詢
	String queryAll1(); //讀取全部資料
	List<member> queryAll2(); //可讀取全部資料，也可一列一列讀取資料
	
	member queryId(int id);//ID查詢
	member queryMember(String username, String password);//查詢username和password資料
	boolean queryUser(String username);//查詢表單內是否帳號重複
	
	//update修改
	void update(member m);
	
	//delet刪除
	void delete(int id);

}
