package com.codingdojo.loginreg.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.loginreg.models.Task;
import com.codingdojo.loginreg.models.User;
import com.codingdojo.loginreg.services.TaskService;
import com.codingdojo.loginreg.services.UserService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	private TaskService tS;
	private UserService uS;
	
	public TaskController(TaskService tS, UserService uS){
		this.tS = tS;
		this.uS = uS;
	}

	
	@GetMapping("/new")
	public String showNewTask(HttpSession session, Model model )
	{
		ArrayList<User> u = uS.findAll();
		model.addAttribute("users", u);
		return "newTask";
	}
	
	@PostMapping("/new")
	public String create( @Valid @ModelAttribute("task") Task task, BindingResult res, Model model, String assignee, HttpSession session, User creator){
		if(res.hasErrors()) {
			return "redirect:/tasks/new";
		}
		else {
			model.addAttribute("assignee", assignee);
			String creatorName = (String) session.getAttribute("user");
			model.addAttribute("creator", creatorName);
			tS.create(task);
			return "redirect:/tasks";}
	}
	
	@GetMapping("")
	public String dashboard(Task task, Model model, HttpSession session, User user) {
		model.addAttribute("task", new Task());
		ArrayList<Task> tasks = tS.findAll();
		model.addAttribute("tasks", tasks);
		return "dashboard";
	}
	@GetMapping("/{id}")
	public String findOne(Model model, @PathVariable("id") Long id ) {
		model.addAttribute("task", tS.findById(id));
		return "tasks2";
	}
	
	@GetMapping("/{id}/edit")
	public String editPage(Model model, @PathVariable("id") Long id, Task task ) {
		ArrayList<User> u = uS.findAll();
		model.addAttribute("users", u);
		model.addAttribute("task", tS.findById(id));
		return "editTask";
	}
	
	@PostMapping("/{id}/update")
	public String update(@Valid @ModelAttribute("product") Task task, BindingResult res, Model model, User user, HttpSession session) {
		if(res.hasErrors()) {
			return "redirect:/tasks/"+task.getId();
		}
		ArrayList<User> u = uS.findAll();
		model.addAttribute("users", u);
		String creatorName = (String) session.getAttribute("user");
		model.addAttribute("creator", creatorName);
		tS.update(task);	
		return "redirect:/tasks/"+task.getId();
	}
	
	@PostMapping("/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		tS.destroy(id);
		return "redirect:/tasks";
	}
	
	
	public TaskService gettS() {
		return tS;
	}

	public void settS(TaskService tS) {
		this.tS = tS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
