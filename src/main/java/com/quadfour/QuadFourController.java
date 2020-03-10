package com.quadfour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import com.quadfour.dto.TaskDTO;
import com.quadfour.dto.CategorizedTasksDTO;

import com.quadfour.service.ITaskService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class QuadFourController {
	
	@Autowired
	private ITaskService taskServiceStub;
	
	/**
	 * '/'
	 * @return index.html
	 */
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(Model model) {

		CategorizedTasksDTO categorizedTasks = taskServiceStub.getCategorizedTasks();
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
	@RequestMapping(value="/quadrant", method=RequestMethod.GET)
	public String quadrant(
			@RequestParam(value="important", defaultValue ="false") boolean important,
			@RequestParam(value="urgent", defaultValue ="false") boolean urgent,
			Model model
	) {

		System.out.println(important);
		System.out.println(urgent);

		ArrayList<TaskDTO> tasks = taskServiceStub.getTasksByQuadrant(important, urgent);
		model.addAttribute("tasks", tasks);

		return "onequadrant";
	}
    
	/**
	 * '/task'
	 * @return task with passed id
	 */
    @RequestMapping(value="/task", method=RequestMethod.GET)
    public String readOne(Model model) {

    	TaskDTO taskDTO = taskServiceStub.fetchById(55); 
    	model.addAttribute("taskDTO", taskDTO);
        return "index";
    }
}

