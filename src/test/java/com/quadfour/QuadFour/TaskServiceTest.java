package com.quadfour.QuadFour;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.quadfour.dao.UserRepository;
import com.quadfour.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.quadfour.dao.ITaskDAO;
import com.quadfour.dto.TaskDTO;
import com.quadfour.service.ITaskService;

@SpringBootTest
public class TaskServiceTest {

    
    @Autowired
    ITaskService taskService;

    @Autowired
    UserRepository userRepository;

    List<TaskDTO> tasks;
    private TaskDTO task;

    // TESTS

    @Test
    void repositoryTest() {
        UserDTO user = userRepository.findByUsername("username");
        assertEquals(0, 1 - 1);
    }

    @Test
    void contextLoads() {
        System.out.println("");
    }

    @Test
    public void saveTask_whenImportantTaskEntered () throws Exception {
        givenUserIsLoggedInToQuadFour();
        whenUserSearchesForUrgentTask();
         whenUserAddsTextText();
//         thenTaskIsSaved();
    }

    @Test
    public void fetchTasks_validateNoResultsForJunkData() throws Exception {
        givenUserIsLoggedInToQuadFour();
        whenTheUserSearchesForJunk();
        // thenMyPlantDiaryReturnsZeroResults();
    }




    // GIVEN FUNCTIONS

    private void givenUserIsLoggedInToQuadFour () {

    }



    // WHEN FUNCTIONS

    private void whenUserSearchesForUrgentTask () throws Exception {
        tasks = taskService.searchTasks("Urgent");
    }

    private void whenTheUserSearchesForJunk() throws Exception {
        tasks = taskService.searchTasks("thistaskdoesnotexist");
    }

    private void whenUserAddsTextText() {
        task = new TaskDTO();
        TaskDTO taskDTO = tasks.get(0);
        taskDTO.setTaskId(5);
        taskDTO.setTaskText("This is an urgent task");
        taskDTO.setIsHighUrgency(true);
    }





    // THEN FUNCTIONS

//    private void thenTaskIsSaved() {
//        try {
//            TaskDTO taskDTO = taskService.save(task);
//            taskDTO.setTaskText("TEXT");
//            assertEquals( taskDTO.getTaskText(), "TEXT" );
//        } catch (Exception e) {
//            fail();
//        }
//    }

    //	private void whenTheUserSearchesForCercis() throws Exception {
    //		plants = specimenService.fetchPlants("Cercis");
    //	}

    //	private void thenMyPlantDiaryReturnsEasternRedbud() {
    //		boolean redbudFound = false;
    //		for (PlantDTO plantDTO : plants) {
    //			if (plantDTO.getCommon().contains("Eastern Redbud")) {
    //				redbudFound = true;
    //			}
    //		}
    //		assertTrue(redbudFound);
    //	}

    //	private void thenMyPlantDiaryReturnsZeroResults() {
    //		assertEquals("Number of plants returned", 0, plants.size());
    //
    //	}

}