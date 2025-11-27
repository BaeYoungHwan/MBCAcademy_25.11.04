package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.AddressDto;

public class AddressDaoImpl implements AddressDao {
	
	Scanner sc = new Scanner(System.in);
	
	private List<AddressDto> list;
	
	public AddressDaoImpl() {
		list = new ArrayList<AddressDto>();
	}	
	
	// CRUD			
	@Override
	public void insert() {
		
		
		// 메모입력은 Scanner를 사용하지 않는다
	}

	@Override
	public void delete() {
		
		
	}

	// 이름, 메모, (전화번호) 
	@Override
	public void select() {
		
		
	}

	@Override
	public void update() {
		
		
	}
	
	// Data save/load
	@Override
	public void save() {
		
		
	}
	@Override
	public void load() {
		
		
	}
	
	
}
