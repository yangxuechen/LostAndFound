package edu.njxz.lostandfound.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.njxz.lostandfound.entity.Comment;
import edu.njxz.lostandfound.entity.Message;
import edu.njxz.lostandfound.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService tess;

	@RequestMapping("/test")
	public String test(Model model) {
		
		List<Message> messages = tess.showAllMessage();
		List<List<Comment>> comments = new ArrayList<List<Comment>>();
		for(int i = 0; i < messages.size(); i++) {
			comments.add(tess.showAllCommentByMessageId(messages.get(i).getMessageId()));
		}
		model.addAttribute("messages", messages);
		model.addAttribute("comments", comments);
		return "test";
	}
	
}
