package ind.sq.activiti.custom;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;

public class UserManagerFactory implements SessionFactory {

    public UserManagerFactory() {
        // TODO Auto-generated constructor stub
    }

    public Class<?> getSessionType() {
        return UserIdentityManager.class;
    }

    public Session openSession() {
        // TODO Auto-generated method stub
        return null;
    }

}
