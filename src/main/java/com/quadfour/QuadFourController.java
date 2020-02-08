package com.quadfour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.quadfour.dto.TaskDTO;
import com.quadfour.service.ITaskService;

@Controller
public class QuadFourController {
	
	@Autowired
	private ITaskService taskServiceStub;
	
	/**
	 * '/'
	 * @return index.html
	 */
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index() {
        return "index";
    }
    
	/**
	 * '/task'
	 * @return task with passed id
	 */
    @RequestMapping(value="/task", method=RequestMethod.GET)
    public String readOne(Model model) {
    	System.out.println("::: /TASK");
    	
    	TaskDTO taskDTO = taskServiceStub.fetchById(55); 
    	model.addAttribute("taskDTO", taskDTO);
        return "index";
    }
}

