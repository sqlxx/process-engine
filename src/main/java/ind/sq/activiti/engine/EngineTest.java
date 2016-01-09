package ind.sq.activiti.engine;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EngineTest {

    private static Logger logger = LoggerFactory.getLogger(EngineTest.class);
    
    public EngineTest() {
        // TODO Auto-generated constructor stub
    }
    
    public static void main(String[] args) {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        ProcessEngine processEngine = configuration.buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("VacationRequest.bpmn20.xml").deploy();
        logger.info("Process definition count {}", repositoryService.createProcessDefinitionQuery().count());
        
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employeeName", "Kermit");
        variables.put("numberOfDays", new Integer(4));
        variables.put("vacationMotivation", "I'm really tired!");
        
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationRequest", variables);
        
        logger.info("Number of process instances: {}", runtimeService.createProcessInstanceQuery().count());
        
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
        
        for (Task task : tasks) {
            logger.info("Task available: " + task.getName());
            taskService.complete(task.getId());
        }
        
    }

}
