package com.myHelp.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myHelp.dao.CategoryDao;
import com.myHelp.dao.EmployeeDao;
import com.myHelp.dao.HistoryDao;
import com.myHelp.dao.TicketDao;
import com.myHelp.domain.Employee;
import com.myHelp.domain.History;
import com.myHelp.domain.Ticket;
import com.myHelp.domain.TicketCategory;
import com.myHelp.domain.User;

@Controller
public class TicketController {
	@Resource(name = "employeeDao")
	EmployeeDao emDao;
	@Resource(name = "ticketDao")
	TicketDao tkDao;
	@Resource(name = "historyDao")
	HistoryDao historyDao;
	@Resource(name = "categoryDao")
	CategoryDao categoryDao;
	
	@RequestMapping(value = "editticketanswer.request", method = RequestMethod.GET)
	public String editTicketAnswer(@RequestParam("ticketid") int id,
			Model model) {
		Ticket t = tkDao.getTicket(id);
		TicketAnswer ticketAnswer = new TicketAnswer(id, t.getAnswer());
		model.addAttribute("ticketanswer", ticketAnswer);
		return "editticketanswer";
	}

	@RequestMapping(value = "editticketanswer.request", method = RequestMethod.POST)
	public String updateTicketAnswer(TicketAnswer ticketAnswer, HttpServletRequest request) {	
		Ticket t = tkDao.getTicket(ticketAnswer.getId());
		t.setAnswer(ticketAnswer.getAnswer());
		t.setCategory("processing");
		tkDao.updateTicket(t);
		
		Date now = new Date();
		String nowTime = new SimpleDateFormat("yyyy-MM-dd").format(now);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(nowTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for(int i = 0; i<historyDao.getHistory().size();i++){
			if(historyDao.getHistory().get(i).getTicketID().equals(ticketAnswer.getId())){
				History history = historyDao.getHistory().get(i);
				history.setResolveTime(date);
				historyDao.updateHistory(history);
			}
		}
		
		return "forward:support.request";
	}
	
	@RequestMapping(value = "editticketquestion.request", method = RequestMethod.GET)
	public String editTicketQuestion(@RequestParam("ticketid") int id,
			Model model) {
		Ticket t = tkDao.getTicket(id);
		TicketQuestion ticketQuestion = new TicketQuestion(id, t.getQuestion());
		model.addAttribute("ticketquestion", ticketQuestion);
		return "editticketquestion";
	}

	@RequestMapping(value = "editticketquestion.request", method = RequestMethod.POST)
	public String updateTicketQuestion(TicketQuestion ticketQuestion) {
		
		Ticket t = tkDao.getTicket(ticketQuestion.getId());
		t.setQuestion(ticketQuestion.getQuestion());
		tkDao.updateTicket(t);
		return "forward:employee.request";
	}
	
	@RequestMapping(value = "createquestion.request", method = RequestMethod.POST)
	public String createTicketQuestion(NewTicket newQuestion, HttpServletRequest req) {
		Ticket t = new Ticket();
		t.setQuestion(newQuestion.getQuestion());
		t.setMaxResponseTime(newQuestion.getDays());
		t.setState(true);
		t.setCategory("open");
		tkDao.addTicket(t);
		
		HttpSession session = req.getSession(); 
		User user = (User)session.getAttribute("user");
		History history = new History();
		Employee employee = new Employee();
		employee.setId(user.getId());
		history.setCreateEmployee(employee);
		history.setTicketID(t.getId());
		Date now = new Date();
		String nowTime = new SimpleDateFormat("yyyy-MM-dd").format(now);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(nowTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		history.setCreateTime(date);
		historyDao.addHistory(history);
		
		return "forward:employee.request";
	}
	
	@RequestMapping("createquestion.request")
	protected ModelAndView creationTicketQuestion() {
		NewTicket newticket = new NewTicket();
		return new ModelAndView("newquestion", "newticket", newticket);
	}
}
