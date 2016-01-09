package ind.sq.activiti.custom;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.GroupIdentityManager;

public class GroupManagerFactory implements SessionFactory {

    public GroupManagerFactory() {
        // TODO Auto-generated constructor stub
    }

    public Class<?> getSessionType() {
        return GroupIdentityManager.class;
    }

    public Session openSession() {
        // TODO Auto-generated method stub
        return null;
    }

}
