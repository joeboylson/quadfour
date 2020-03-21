package com.quadfour;
import com.quadfour.service.ICategorizedTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

import com.quadfour.dto.TaskDTO;
import com.quadfour.dto.CategorizedTasksDTO;

import com.quadfour.service.ITaskService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class QuadFourController {

	@Autowired
	private ITaskService taskService;

	@Autowired
	private ICategorizedTasksService categorizedTasksService;



	// =================================================================================================================
	// GET
	// =================================================================================================================

	/**
	 * '/'
	 * @return index.html
	 */
    @RequestMapping(value="/")
    public String index(Model model) {

		CategorizedTasksDTO categorizedTasks = categorizedTasksService.getCategorizedTasks();
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
			Model model
	) {

		ArrayList<TaskDTO> tasks = categorizedTasksService.getTasksByQuadrant(important, urgent);
		model.addAttribute("tasks", tasks);

		return "onequadrant";
	}

	/**
	 * '/task'
	 * @return tasks
	 */
    @RequestMapping(value="/task")
    public String task(@RequestParam(value="taskId") Integer taskId, Model model) {

    	// TODO: add in route/behavior for "/task" without "taskId" parameter

    	TaskDTO taskDTO = taskService.fetchById(taskId);
    	model.addAttribute("task", taskDTO);
        return "task";
    }

	/**
	 * '/newtask'
	 * @return tasks
	 */
	@RequestMapping(value="/newtask")
	public String newTask(Model model) {
		TaskDTO taskDTO = new TaskDTO();
		model.addAttribute("task", taskDTO);
		model.addAttribute("formaction", "/save");
		return "taskform";
	}

	/**
	 * '/newtask'
	 * @return tasks
	 */
	@RequestMapping(value="/duplicatetask")
	public String duplicateTask(@RequestParam(value="taskId", defaultValue = "0") Integer taskId, Model model) {

		TaskDTO taskDTO = taskService.fetchById(taskId);
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
	public String updateTask(@RequestParam(value="taskId", defaultValue = "0") Integer taskId, Model model) {

		TaskDTO taskDTO = taskService.fetchById(taskId);
		model.addAttribute("task", taskDTO);
		model.addAttribute("formaction", "/save?taskId=" + taskId);
		return "taskform";
	}

	/**
	 * '/newtask'
	 * @return tasks
	 */
	@RequestMapping(value="/deletetask")
	public String deleteTask(@RequestParam(value="taskId", defaultValue = "0") Integer taskId) {
		taskService.deleteById(taskId);
		return "redirect:/";
	}



	// =================================================================================================================
    // POST
	// =================================================================================================================

	@PostMapping(value="/save")
	public String save(
			@RequestParam(value="taskId", defaultValue = "0") Integer taskId,
			TaskDTO task,
			RedirectAttributes redirectAttributes) {

    	try{

    		task.setTaskId(taskId);
			TaskDTO savedTask = taskService.save(task);
			System.out.println(savedTask);

			redirectAttributes.addAttribute("taskId", savedTask.getTaskId());
			return "redirect:task";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("there was an error");
		}

		return "redirect:/";
	}
}

