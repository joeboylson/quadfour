package com.quadfour;
import com.quadfour.dto.QuadrantDTO;
import com.quadfour.dto.UserDTO;
import com.quadfour.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.quadfour.dto.TaskDTO;
import com.quadfour.dto.CategorizedTasksDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.security.Principal;

@Controller
public class QuadFourController {

	@Autowired
	private IUserService userService;

	@Autowired
	private ITaskService taskService;

	@Autowired
	private IQuadrantService quadrantService;

	@Autowired
	private ICategorizedTasksService categorizedTasksService;

	@Autowired
	private UserDetailsService userDetailsService;

	private UserDTO getUserFromPrincipal(Principal principal) {
		String username = principal.getName();
		UserDTO user = userService.findByUsername(username);
		return user;
	}



	// =================================================================================================================
	// GET
	// =================================================================================================================

	/**
	 * '/'
	 * @return index.html
	 */
    @RequestMapping(value="/")
    public String index(Principal principal, Model model) {

    	UserDTO activeUser = getUserFromPrincipal(principal);
		CategorizedTasksDTO categorizedTasks = categorizedTasksService.getCategorizedTasks( activeUser.getId() );

		model.addAttribute("importantUrgent", categorizedTasks.getImportantUrgent());
		model.addAttribute("importantNotUrgent", categorizedTasks.getImportantNotUrgent());
		model.addAttribute("notImportantUrgent", categorizedTasks.getNotImportantUrgent());
		model.addAttribute("notImportantNotUrgent", categorizedTasks.getNotImportantNotUrgent());

    	return "index";
    }

	/**
	 * '/task'
	 * @return index.html
	 */
	@RequestMapping(value="/quadrant")
	public String quadrant(
			@RequestParam(value="important", defaultValue ="false") boolean important,
			@RequestParam(value="urgent", defaultValue ="false") boolean urgent,
			Model model,
			Principal principal
	) {

		UserDTO activeUser = getUserFromPrincipal(principal);
		QuadrantDTO quadrant = quadrantService.getQuadrant(important, urgent, activeUser.getId());
		model.addAttribute("quadrant", quadrant);

		return "onequadrant";
	}

	/**
	 * '/task'
	 * @return tasks
	 */
    @RequestMapping(value="/task")
    public String task(
    		@RequestParam(value="taskId") Integer taskId,
			Model model,
			Principal principal
	) {

		UserDTO activeUser = getUserFromPrincipal(principal);
    	TaskDTO taskDTO = taskService.fetchById(taskId, activeUser.getId());
    	model.addAttribute("task", taskDTO);
        return "task";
    }

	/**
	 * '/newtask'
	 * @return tasks
	 */
	@RequestMapping(value="/newtask")
	public String newTask(
			@RequestParam(value="important", defaultValue ="false") boolean important,
			@RequestParam(value="urgent", defaultValue ="false") boolean urgent,
			Model model
	) {
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setIsHighImportance(important);
		taskDTO.setIsHighUrgency(urgent);
		model.addAttribute("task", taskDTO);
		model.addAttribute("formaction", "/save");
		return "taskform";
	}

	/**
	 * '/newtask'
	 * @return tasks
	 */
	@RequestMapping(value="/duplicatetask")
	public String duplicateTask(
			@RequestParam(value="taskId", defaultValue = "0") Integer taskId,
			Model model,
			Principal principal
	) {

		UserDTO activeUser = getUserFromPrincipal(principal);
		TaskDTO taskDTO = taskService.fetchById(taskId, activeUser.getId());
		taskDTO.setTaskId(0);
		model.addAttribute("task", taskDTO);
		model.addAttribute("formaction", "/save");
		return "taskform";
	}

	/**
	 * '/newtask'
	 * @return tasks
	 */
	@RequestMapping(value="/updatetask")
	public String updateTask(
			@RequestParam(value="taskId", defaultValue = "0") Integer taskId,
			Model model,
			Principal principal
	) {

		UserDTO activeUser = getUserFromPrincipal(principal);
		TaskDTO taskDTO = taskService.fetchById(taskId, activeUser.getId());
		model.addAttribute("task", taskDTO);
		model.addAttribute("formaction", "/save?taskId=" + taskId);
		return "taskform";
	}

	/**
	 * '/newtask'
	 * @return tasks
	 */
	@RequestMapping(value="/deletetask")
	public String deleteTask(@RequestParam(value="taskId", defaultValue = "0") Integer taskId, Principal principal) {
		UserDTO activeUser = getUserFromPrincipal(principal);
		taskService.deleteById(taskId, activeUser.getId());
		return "redirect:/";
	}

	/**
	 * '/login'
	 * @return login page
	 */
	@RequestMapping(value="/login")
	public String login(Model model) {
		UserDTO user = new UserDTO();

		model.addAttribute("user", user);
		return "login";
	}

	/**
	 * '/register'
	 * @return register page
	 */
	@RequestMapping(value="/register")
	public String register(Model model) {
		UserDTO user = new UserDTO();
		String confirmPassword = "";

		model.addAttribute("user", user);
		model.addAttribute("confirmPassword", confirmPassword);
		return "register";
	}


	// =================================================================================================================
    // POST
	// =================================================================================================================

	@PostMapping(value="/save")
	public String save(
			@RequestParam(value="taskId", defaultValue = "0") Integer taskId,
			TaskDTO task,
			RedirectAttributes redirectAttributes,
			Principal principal
	) {

    	try{
			UserDTO activeUser = getUserFromPrincipal(principal);

    		task.setTaskId(taskId);
			TaskDTO savedTask = taskService.save(task, activeUser.getId());
			System.out.println(savedTask);

			redirectAttributes.addAttribute("taskId", savedTask.getTaskId());
			return "redirect:task";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("there was an error");
		}

		return "redirect:/";
	}

	@PostMapping(value="/register")
	public String save(
			UserDTO user,
			String confirmPassword,
			RedirectAttributes redirectAttributes
	) {
		try{

			if ( user.getPassword().equals(confirmPassword) ) {
				userDetailsService.register(user);
				return "redirect:/";
			}

			redirectAttributes.addAttribute("message", "Passwords do not match");
			return "redirect:/register";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("there was an error");
		}

		return "redirect:/";
	}
}

