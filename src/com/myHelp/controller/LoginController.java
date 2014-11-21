package com.myHelp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import com.myHelp.dao.EmployeeDao;
import com.myHelp.dao.TicketDao;
import com.myHelp.dao.UserDao;
import com.myHelp.domain.History;
import com.myHelp.domain.Ticket;
import com.myHelp.domain.User;
import com.myHelp.domain.Employee;

@Controller
@SessionAttributes(value = "loginUser")  
public class LoginController {
	
	@Resource(name = "userDao")
	UserDao dao;
	@Resource(name = "employeeDao")
	EmployeeDao emDao;
	@Resource(name = "ticketDao")
	TicketDao tkDao;
	@RequestMapping(value = "signup.request", method = RequestMethod.GET)
	protected String showContactForm(User user) {
		return "signup";
	}	
	private int i = 0;
	@RequestMapping(value = "login.request",method = RequestMethod.POST)
	public String login(String username,String password,Model model,HttpServletRequest req){
		for(i=0;i<dao.getUsers().size();i++){
			if(dao.getUsers().get(i).getUsername().equals(username)&&dao.getUsers().get(i).getPassword().equals(password)){
				model.addAttribute("loginUser", dao.getUsers().get(i));
				model.addAttribute("employee", emDao.getEmployee(dao.getUsers().get(i).getId()));
				List<History> ticketHistory = emDao.getEmployees().get(i).getCreateHistorys();
				model.addAttribute("ticketHistory", ticketHistory);
				model.addAttribute("tickets", tkDao.getTickets());
				model.addAttribute("opentickets", tkDao.getOpenTickets());
				if(dao.getUsers().get(i).getRole().equals("employee")){
					return "employee";
				}
				else if(dao.getUsers().get(i).getRole().equals("support")){
					return "support";
				}
				
			}
		}

		return "unsuccess";
	}
	@RequestMapping("support.request")
	protected ModelAndView displaySupport() {
		List<Ticket> tickets = tkDao.getOpenTickets();
		return new ModelAndView("support", "opentickets", tickets);
	}
	
	
}
