package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
public class phoneBookController {
	
	//필드
	//메모리에 올림
	@Autowired
	private PhonebookService phonebookService;
	//생성자
	
	
	//메소드 g/s
	
	
	//메소드 일반
	
	@RequestMapping(value="/phone/modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("phoneBookController.modify()");
		System.out.println(personVo);
		phonebookService.exeModify(personVo);
		
		return "redirect:/phone/list";

	}
	
	@RequestMapping(value="/phone/modifyform", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyform(@RequestParam(value="no") int no, Model model) {
		System.out.println("phoneBookController.modifyform()");
		
		//PhonebookService phonebookService = new PhonebookService();
		PersonVo personVo = phonebookService.exeModifyForm(no);
		
		model.addAttribute("personVo", personVo);
		
		return "modifyForm";
	
	}
	
	@RequestMapping(value="/phone/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value="no") int no) {
		System.out.println("phoneBookController.delete()");
		
		System.out.println(no);
		//PhonebookService phonebookService = new PhonebookService();
		phonebookService.exeDelete(no);
		
		//PhoneDao phoneDao = new PhoneDao();
		//phoneDao.personDelete(no);
		
		return "redirect:/phone/list";
	}
	
	@RequestMapping(value="/phone/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("phoneBookController.list()");
		
		//PhonebookService phonebookService = new PhonebookService();
		List<PersonVo> personList = phonebookService.exeList();
		
		//PhoneDao phoneDao = new PhoneDao();
		
		//List<PersonVo>personList = phoneDao.personSelect();
		
		model.addAttribute("pList", personList);
		System.out.println(personList);
		
		return "list";
	}
	@RequestMapping(value="/phone/writeForm", method= {RequestMethod.POST, RequestMethod.GET})
	public String writeForm() {
		System.out.println("phoneBookController.writeForm()");
		
		return "writeForm";
		
	}
	@RequestMapping(value="/phone/write2", method = {RequestMethod.GET, RequestMethod.POST})
	public String write2(@ModelAttribute PersonVo personVo) {
		System.out.println("phoneBookController.write2()");
		
		//PersonVo personVo = new PersonVo(name, hp, company);
		
		System.out.println(personVo.toString());
		
		//서비스를 메모리에 올리고
		//서비스의 메소드를 사용해야함
		//PhonebookService phonebookService = new PhonebookService();
		phonebookService.exeWrite(personVo);
		
		//PhoneDao phoneDao = new PhoneDao();
		//phoneDao.personInsert(personVo);
		
		return "redirect:/phone/list";
	}
	/*@RequestMapping(value="/phone/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("phoneBookController.list()");
		
		PhoneDao phoneDao = new PhoneDao();
		
		List<PersonVo>personList = phoneDao.personSelect();
		
		model.addAttribute("pList", personList);
		System.out.println(personList);
		
		return "list";
	}*/
	
	/*
	@RequestMapping(value="/phone/modifyform", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyform(@RequestParam(value="no") int no, Model model) {
		System.out.println("phoneBookController.modifyform()");
		
		PhoneDao phoneDao = new PhoneDao();
		
		PersonVo personVo = phoneDao.personSelectOne(no);
		System.out.println(personVo);
		
		model.addAttribute("personVo", personVo);
		
		return "modifyForm";
	
	}*/
	/*
	@RequestMapping(value="/modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("phoneBookController.modify()");
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personUpdate(personVo);
		
		return "redirect:/phone/list";
	}*/

	/*
	@RequestMapping(value="/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value="no") int no) {
		System.out.println("phoneBookController.delete()");
		
		System.out.println(no);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personDelete(no);
		
		return "redirect:/phone/list";
	}
	*/
	
}

