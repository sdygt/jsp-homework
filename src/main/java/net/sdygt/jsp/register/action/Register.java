package net.sdygt.jsp.register.action;

import com.opensymphony.xwork2.ActionSupport;
import net.sdygt.jsp.register.model.User;

import java.sql.SQLException;

public class Register extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private User userBean = new User();


    public String execute() throws Exception {
        try {
            if (userBean.save()) {
                return SUCCESS;
            } else {
                return ERROR;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User user) {
        userBean = user;
    }

}
