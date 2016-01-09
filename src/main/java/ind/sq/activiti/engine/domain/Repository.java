package ind.sq.activiti.engine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private static Repository repo = new Repository();
    private Map<Integer, UserEntity> userMap = new HashMap<Integer, UserEntity>();
    
    public static Repository getInstance() {
        return repo;
    }
    
    public Repository() {
        UserEntity employee = new UserEntity(1, "employee");
        employee.setReportToId(2);
        UserEntity manager = new UserEntity(2, "manager");
        manager.setReportToId(5);
        UserEntity accountant1 = new UserEntity(3, "accountant1");
        UserEntity cashier = new UserEntity(4, "cashier");
        UserEntity boss = new UserEntity(5, "boss");
        UserEntity accountant2 = new UserEntity(6, "accountant2");
        
        userMap.put(employee.getUserId(), employee);
        userMap.put(manager.getUserId(), manager);
        userMap.put(accountant1.getUserId(), accountant1);
        userMap.put(accountant2.getUserId(), accountant2);
        userMap.put(cashier.getUserId(), cashier);
        userMap.put(boss.getUserId(), boss);
        
    }
    
    public UserEntity getUser(int id) {
        return userMap.get(id);
    }
    
    public List<UserEntity> getAccountantsGroup() {
        List<UserEntity> list = new ArrayList<UserEntity>();
        
        list.add(userMap.get(3));
        list.add(userMap.get(6));
        
        return list;
    }

    public List<UserEntity> getCashierGroup() {
        List<UserEntity> list = new ArrayList<UserEntity>();
        
        list.add(userMap.get(4));
        
        return list;
    }


}
