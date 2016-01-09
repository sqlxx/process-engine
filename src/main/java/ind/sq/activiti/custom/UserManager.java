package ind.sq.activiti.custom;

import ind.sq.activiti.engine.domain.Repository;

import java.util.List;
import java.util.Map;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;
import org.apache.commons.lang3.NotImplementedException;

public class UserManager implements UserIdentityManager {

    public UserManager() {
        // TODO Auto-generated constructor stub
    }

    public User createNewUser(String userId) {
        throw new NotImplementedException("Not allowed");
    }

    public void insertUser(User user) {
        throw new NotImplementedException("Not allowed");
        
    }

    public void updateUser(User updatedUser) {
        throw new NotImplementedException("Not allowed");
        
    }

    public User findUserById(String userId) {
        User user = Repository.getInstance().getUser(Integer.parseInt(userId));
        
        return user;
    }

    public void deleteUser(String userId) {
        // TODO Auto-generated method stub
        
    }

    public List<User> findUserByQueryCriteria(UserQueryImpl query, Page page) {
        // TODO Auto-generated method stub
        return null;
    }

    public long findUserCountByQueryCriteria(UserQueryImpl query) {
        // TODO Auto-generated method stub
        return 0;
    }

    public List<Group> findGroupsByUser(String userId) {
        // TODO Auto-generated method stub
        return null;
    }

    public UserQuery createNewUserQuery() {
        // TODO Auto-generated method stub
        return null;
    }

    public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId, String key) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<String> findUserInfoKeysByUserIdAndType(String userId, String type) {
        // TODO Auto-generated method stub
        return null;
    }

    public Boolean checkPassword(String userId, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<User> findPotentialStarterUsers(String proceDefId) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<User> findUsersByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

    public long findUserCountByNativeQuery(Map<String, Object> parameterMap) {
        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isNewUser(User user) {
        // TODO Auto-generated method stub
        return false;
    }

    public Picture getUserPicture(String userId) {
        // TODO Auto-generated method stub
        return null;
    }

    public void setUserPicture(String userId, Picture picture) {
        // TODO Auto-generated method stub
        
    }

}
