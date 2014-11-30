package com.myHelp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;













import com.myHelp.dao.EmployeeDao;
import com.myHelp.dao.HistoryDao;
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
	@Resource(name = "historyDao")
	HistoryDao historyDao;
	@RequestMapping(value = "signup.request", method = RequestMethod.GET)
	protected String showContactForm(User user) {
		return "signup";
	}	
	private int i = 0;
	
	@RequestMapping(value = "login.request",method = RequestMethod.POST)
	public String login(String username,String password,Model model,HttpServletRequest req){
		HttpSession session = req.getSession(); 
		for(i=0;i<dao.getUsers().size();i++){
			if(dao.getUsers().get(i).getUsername().equals(username)&&dao.getUsers().get(i).getPassword().equals(password)){
				model.addAttribute("loginUser", dao.getUsers().get(i));
				model.addAttribute("employee", emDao.getEmployee(dao.getUsers().get(i).getId()));
				List<History> ticketHistory = emDao.getEmployees().get(i).getCreateHistorys();
				model.addAttribute("ticketHistory", ticketHistory);
				model.addAttribute("tickets", tkDao.getTickets());
				model.addAttribute("opentickets", tkDao.getOpenTickets());
				session.setAttribute("user", dao.getUsers().get(i));
				List<Ticket> tickets = tkDao.getTickets();
				List<History> historys = historyDao.getHistory();
				model.addAttribute("tickets", tickets);
				model.addAttribute("historys", historys);
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

	@SuppressWarnings("null")
	@RequestMapping(value="support.request", method = RequestMethod.POST)
	protected String getSupport(Model model,HttpServletRequest request) throws Exception {
		SimpleDateFormat sdf  =   new  SimpleDateFormat("yyyy-MM-dd" ); 
		List<Ticket> tickets = tkDao.getTickets();
		List<History> historys = historyDao.getHistory();
		List<Ticket> optickets = new ArrayList<Ticket>();
		List<History> ophistorys = new ArrayList<History>();

		model.addAttribute("historys", historys);
		String[] option = request.getParameterValues("searchoption");
		String[] begin = request.getParameterValues("begin");
		String[] end = request.getParameterValues("end");


		if(option[0].equals("all")){
			optickets=tickets;
			ophistorys=historys;
		}else if(option[0].equals("open")){
		
			for(int i= 0; i<tickets.size();i++){
				if(tickets.get(i).getCategory().equals("open")){
					optickets.add(tickets.get(i));
					ophistorys.add(historys.get(i));
				}
			}
		}else if(option[0].equals("processing")){
		
			for(int i= 0; i<tickets.size();i++){
				if(tickets.get(i).getCategory().equals("processing")){
					optickets.add(tickets.get(i));
					ophistorys.add(historys.get(i));
				}
			}
		}else if(option[0].equals("closed")){
		
			for(int i= 0; i<tickets.size();i++){
				if(tickets.get(i).getCategory().equals("closed")){
					optickets.add(tickets.get(i));
					ophistorys.add(historys.get(i));
				}
			}
		}
		

		if(begin[0]!=""){

			for(int i=0; i<optickets.size();i++){
				Date begindate = sdf.parse(begin[0]);
				String str1 = sdf.format(begindate);
				String str2 = sdf.format(ophistorys.get(i).getCreateTime());
				System.out.println(str1+"   "+ str2);
				int ss = begindate.compareTo(ophistorys.get(i).getCreateTime());
				if(ss>0){
					optickets.remove(i);
				}

			}
		}
		if(end[0]!=""){
			Date enddate = sdf.parse(end[0]);
			for(int i=0; i<optickets.size();i++){
				int ss = enddate.compareTo(ophistorys.get(i).getCreateTime());
				if(ss<0){
					optickets.remove(i);
				}
			}
		}

		
		model.addAttribute("tickets", optickets);
		String[] choose = request.getParameterValues("choose");
		if(choose!=null){
			for(String s:choose){
				tickets.get(Integer.parseInt(s)-1).setState(false);
				tickets.get(Integer.parseInt(s)-1).setCategory("closed");
				tkDao.updateTicket(tickets.get(Integer.parseInt(s)-1));
			}
		return "support";
		}else{
			return "support";
		}
	}
	
	@RequestMapping(value="employee.request",method = RequestMethod.POST)
	protected String displayEmployee(Model model,HttpServletRequest req) {
		HttpSession session = req.getSession(); 
		User user = (User)session.getAttribute("user");
		model.addAttribute("loginUser", dao.getUsers().get(user.getId()-1));
		model.addAttribute("employee", emDao.getEmployee(dao.getUsers().get(user.getId()-1).getId()));
		List<History> ticketHistory = emDao.getEmployees().get(user.getId()-1).getCreateHistorys();
		model.addAttribute("ticketHistory", ticketHistory);
		model.addAttribute("tickets", tkDao.getTickets());
		return "employee";
	}
	
}
