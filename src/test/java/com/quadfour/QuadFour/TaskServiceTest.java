package com.quadfour.QuadFour;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.quadfour.dao.ITaskDAO;
import com.quadfour.dto.TaskDTO;
import com.quadfour.service.ITaskService;

@SpringBootTest
public class TaskServiceTest {

    @Qualifier("taskServiceStub")
    @Autowired
    ITaskService taskService;

    List<TaskDTO> tasks;
    private TaskDTO task;

    // TESTS

    @Test
    void contextLoads() {
        System.out.println("");
    }

    @Test
    public void saveTask_whenImportantTaskEntered () throws Exception {
        givenUserIsLoggedInToQuadFour();
        whenUserSearchesForUrgentTask();
         whenUserAddsTextText();
         thenTaskIsSaved();
    }

    @Test
    public void fetchTasks_validateNoResultsForJunkData() throws Exception {
        givenUserIsLoggedInToQuadFour();
        whenTheUserSearchesForJunk();
        // thenMyPlantDiaryReturnsZeroResults();
    }

    @Test
    public void fetchPlants_validateResultsForCercis() throws Exception {
        givenUserIsLoggedInToQuadFour();
        // whenTheUserSearchesForCercis();
        // thenMyPlantDiaryReturnsEasternRedbud();
    }



    // GIVEN FUNCTIONS

    private void givenUserIsLoggedInToQuadFour () {

    }



    // WHEN FUNCTIONS

    private void whenUserSearchesForUrgentTask () throws Exception {
        tasks = taskService.fetchTasks("Urgent");
    }

    private void whenTheUserSearchesForJunk() throws Exception {
        tasks = taskService.fetchTasks("thistaskdoesnotexist");
    }

    private void whenUserAddsTextText() {
        task = new TaskDTO();
        TaskDTO taskDTO = tasks.get(0);
        taskDTO.setTaskId(5);
        taskDTO.setTaskText("This is an urgent task");
        taskDTO.setIsHighUrgency(true);
    }





    // THEN FUNCTIONS

    private void thenTaskIsSaved() {
        try {
            boolean result = taskService.save(task);
            assertTrue(result);
        } catch (Exception e) {
            fail();
        }
    }

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