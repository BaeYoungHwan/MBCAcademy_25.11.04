package dao;

public interface AccountDAO {
	
	// 함수를 정의한다. 사용할 함수 종류별로 선언
	void insert();
	void delete();
	void select();
	void update();
		
	void save();
	void load();
	
	void all();
	
}
