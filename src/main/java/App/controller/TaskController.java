package App.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import App.service.TaskService;
import App.userinfo.User;
import App.userinfo.data;

@Controller
public class TaskController {

	@Autowired 
	private TaskService taskService;
	

	   
	//@Autowired
	//private HttpServletRequest request;
	
	@GetMapping("/")
	public String home(HttpServletRequest request )
	{
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	/*@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(ModelMap model){
		//this.getData();
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	} */
	
	
	
	@GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request)
	{
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/new-task")
	public String newTask(HttpServletRequest request)
	{
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute data d, BindingResult bindingResult, HttpServletRequest request)
	{
		d.setDate(new Date());
		taskService.save(d);
		
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/update-task")
	public String updateTask(@RequestParam int id, HttpServletRequest request)
	{
		request.setAttribute("tasks", taskService.findTask(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam int id, HttpServletRequest request)
	{
		taskService.delete(id);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
}

