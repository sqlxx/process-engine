package ind.sq.activiti.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringEngineTest {

    private static final Logger logger = LoggerFactory.getLogger(SpringEngineTest.class);

    public SpringEngineTest() {
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        RepositoryService repoService = (RepositoryService) applicationContext.getBean("repositoryService");

        repoService.createDeployment().addClasspathResource("VacationRequest.bpmn20.xml").deploy();
        logger.info("Process definition count {}", repoService.createProcessDefinitionQuery().latestVersion().count());

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employeeId", 1);
        variables.put("numberOfDays", new Integer(4));
        variables.put("vacationMotivation", "I'm really tired!");
        variables.put("currentOperator", 1);

        RuntimeService runtimeService = (RuntimeService) applicationContext.getBean("runtimeService");
        ProcessInstance newVacationRequest = runtimeService.startProcessInstanceByKey("vacationRequest", "BAOXIAODAN_1", variables);

        logger.info("Number of process instances: {}", runtimeService.createProcessInstanceQuery().count());
        List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery().list();
        
        TaskService taskService = (TaskService) applicationContext.getBean("taskService");
        for (ProcessInstance processInstance : processInstances) {
            String key = processInstance.getProcessInstanceId();
            List<Task> currentTasks = taskService.createTaskQuery().processInstanceId(key).list();
            
            for (Task task : currentTasks) {
                logger.info("Task available: " + task.getName() + " asignee: " + task.getAssignee());
                task.setAssignee("2");
                taskService.saveTask(task);
                logger.info("Task available: " + task.getName() + " asignee: " + task.getAssignee());
            }
        }
        List<Task> tasks = null;
        
        tasks = taskService.createTaskQuery().taskAssignee("3").list();
       logger.info("Task count for user id = 3: " + tasks.size());
       
       tasks = taskService.createTaskQuery().taskAssignee("5").list();
      logger.info("Task count for user id = 5: " + tasks.size());
        
        tasks = taskService.createTaskQuery().taskAssignee("2").list();
        logger.info("Task count for user id = 2: " + tasks.size());
        for (Task task : tasks) {
            logger.info("Task available: " + task.getName());
            Map<String, Object> vars = new HashMap<String, Object>();
            vars.put("vacationApproved", true);
            vars.put("currentOperator", 2);
            taskService.complete(task.getId(), vars);
        }
        
        tasks = taskService.createTaskQuery().taskAssignee("5").list();
        logger.info("Task count for user id = 5: " + tasks.size());
        
         tasks = taskService.createTaskQuery().taskAssignee("3").list();
        logger.info("Task count for user id = 3: " + tasks.size());
        for (Task task : tasks) { 
            logger.info("Task available: " + task.getName());
            Map<String, Object> vars = new HashMap<String, Object>();
            vars.put("vacationApproved", true);
            vars.put("currentOperator", 3);
            taskService.complete(task.getId(), vars);
        }
        
        tasks = taskService.createTaskQuery().taskAssignee("5").list();
        logger.info("Task count for user id = 5: " + tasks.size());
        for (Task task : tasks) {
            logger.info("Task available: " + task.getName());
            Map<String, Object> vars = new HashMap<String, Object>();
            vars.put("vacationApproved", true);
            vars.put("currentOperator", 5);
            taskService.complete(task.getId(), vars);
        }
        
        tasks = taskService.createTaskQuery().taskCandidateOrAssigned("5").list();
        logger.info("Task count for user id = 5: " + tasks.size());
        
        
        //accountant should have tasks now
        tasks = taskService.createTaskQuery().taskCandidateOrAssigned("6").list();
        logger.info("Task count for user id = 6: " + tasks.size());
        tasks = taskService.createTaskQuery().taskCandidateOrAssigned("3").list();
        logger.info("Task count for user id = 3: " + tasks.size());
        
        for (Task task : tasks) {
            logger.info("Task available: " + task.getName());
            Map<String, Object> vars = new HashMap<String, Object>();
            vars.put("vacationApproved", true);
            vars.put("currentOperator", 6);
            taskService.claim(task.getId(), "6");
            taskService.complete(task.getId(), vars);
        }
        logger.info("Accountant 6 finished all task: " + tasks.size());
        
        tasks = taskService.createTaskQuery().taskCandidateOrAssigned("6").list();
        logger.info("Task count for user id = 6: " + tasks.size());
        tasks = taskService.createTaskQuery().taskCandidateOrAssigned("3").list();
        logger.info("Task count for user id = 3: " + tasks.size());
        
        tasks = taskService.createTaskQuery().taskCandidateOrAssigned("4").list();
        logger.info("Task count for user id = 4: " + tasks.size());
        
        for (Task task : tasks) {
            logger.info("Task available: " + task.getName());
            Map<String, Object> vars = new HashMap<String, Object>();
            vars.put("vacationApproved", true);
            vars.put("currentOperator", 4);
            taskService.claim(task.getId(), "4");
            taskService.complete(task.getId(), vars);
        }
        
        logger.info("Work flow completed: " + tasks.size());
        
    }

}
