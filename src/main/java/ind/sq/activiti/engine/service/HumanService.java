package ind.sq.activiti.engine.service;

import ind.sq.activiti.engine.domain.Repository;
import ind.sq.activiti.engine.domain.Roles;
import ind.sq.activiti.engine.domain.UserEntity;
import java.util.ArrayList;
import java.util.List;

public class HumanService {

    public HumanService() {
        // TODO Auto-generated constructor stub
    }

    public Integer getDirectManagerId(int userId) {
        UserEntity user = Repository.getInstance().getUser(userId);

        Integer reportToId = user.getReportToId();
        return reportToId;
    }

    public List<String> getUsersByRole(String role) {

        List<String> list = new ArrayList<String>();

        if (role.equalsIgnoreCase(Roles.ACCOUNTANT.toString())) {
            List<UserEntity> userList = Repository.getInstance().getAccountantsGroup();

            for (UserEntity user : userList) {
                list.add(user.getUserId() + "");
            }
        } else if (role.equalsIgnoreCase(Roles.CASHIER.toString())) {
            List<UserEntity> userList = Repository.getInstance().getCashierGroup();

            for (UserEntity user : userList) {
                list.add(user.getUserId() + "");
            }
        }
        return list;
    }

}
