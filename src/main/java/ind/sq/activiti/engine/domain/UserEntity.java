package ind.sq.activiti.engine.domain;

import org.activiti.engine.identity.User;

public class UserEntity implements User {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int userId;
    private String userName;
    private Roles userRole;
    private Integer reportToId;
    private int deptId;
    
    
    public UserEntity(int id, String userName) {
        this.userId = id;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Roles getUserRole() {
        return userRole;
    }

    public void setUserRole(Roles userRole) {
        this.userRole = userRole;
    }

    public Integer getReportToId() {
        return reportToId;
    }

    public void setReportToId(Integer reportToId) {
        this.reportToId = reportToId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getId() {
        return null;
    }

    public void setId(String id) {
        
    }

    public String getFirstName() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setFirstName(String firstName) {
        // TODO Auto-generated method stub
        
    }

    public void setLastName(String lastName) {
        // TODO Auto-generated method stub
        
    }

    public String getLastName() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setEmail(String email) {
        // TODO Auto-generated method stub
        
    }

    public String getEmail() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getPassword() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setPassword(String string) {
        // TODO Auto-generated method stub
        
    }

    public boolean isPictureSet() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
