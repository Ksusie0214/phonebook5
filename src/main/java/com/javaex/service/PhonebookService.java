package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;
@Service
public class PhonebookService {
	
	//필드
	@Autowired
	private PhoneDao phoneDao;
	
	//생성자
	
	//메소드 g/s
	
	//메소드일반
	public void exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");
		
		//비지니스 로직X
		//PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
	}
	
	public List<PersonVo> exeList() {
		System.out.println("PhonebookService.exeList()");
		
		//비지니스 로직X
		//PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.personSelect();
		
		return personList;
		
	}
	
	public void exeDelete(int no) {
		System.out.println("PhonebookService.exeDelete()");
		
		//PhoneDao phoneDao = new PhoneDao();
		phoneDao.personDelete(no);
	}
	
	public PersonVo exeModifyForm(int no) {
		System.out.println("PhonebookService.exeModifyForm()");
		
		//PhoneDao phoneDao = new PhoneDao();
		PersonVo personVo = phoneDao.personSelectOne(no);
		
		return personVo;
	}
	
	public void exeModify(PersonVo personVo) {
		System.out.println("PhonebookService.exeModify()");
		
		//PhoneDao phoneDao = new PhoneDao();
		phoneDao.personUpdate(personVo);
		
		
	}
}
