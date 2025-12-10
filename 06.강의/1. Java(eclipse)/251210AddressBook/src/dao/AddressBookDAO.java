package dao;

import java.util.List;

import dto.AddressBookDTO;

public interface AddressBookDAO {
	
	public void insert();
	public int insert(String name, int age, String phone, String address, String memo);
	public void delete();
	public int delete(int id);
	public void update();
	public int update(int number, int updateID, String value);
	public void search();
	public void selectALL();
	public AddressBookDTO search(int number, String value);
	
}























