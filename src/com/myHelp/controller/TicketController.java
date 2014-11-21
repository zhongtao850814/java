package com.myHelp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myHelp.dao.EmployeeDao;
import com.myHelp.dao.TicketDao;
import com.myHelp.domain.Ticket;

@Controller
public class TicketController {
	@Resource(name = "employeeDao")
	EmployeeDao emDao;
	@Resource(name = "ticketDao")
	TicketDao tkDao;
	
	@RequestMapping(value = "editticketanswer.request", method = RequestMethod.GET)
	public String editTicketAnswer(@RequestParam("ticketid") int id,
			Model model) {
		Ticket t = tkDao.getTicket(id);
//		MeetingDateCommand contactMeetings = new MeetingDateCommand(id,
//				c.getDisplayName(), c.getMeetingDates());
//		model.addAttribute("contactMeetings", contactMeetings);
		TicketCommand ticketAnswer = new TicketCommand(id, t.getAnswer());
		model.addAttribute("ticketanswer", ticketAnswer);
		return "editticketanswer";
	}

	@RequestMapping(value = "editticketanswer.request", method = RequestMethod.POST)
	public String updateTicketAnswer(TicketCommand ticketAnswer) {
		
	//	Contact contact = contactDao.getContact(contactMeetings.getId());
		Ticket t = tkDao.getTicket(ticketAnswer.getId());
	//	contact.setMeetingDates(contactMeetings.getMeetingDates());
		t.setAnswer(ticketAnswer.getAnswer());
	//	contactDao.updateContact(contact);
		tkDao.updateTicket(t);
		return "forward:support.request";
	}
}
