package net.sdygt.jsp.login.action;

import com.opensymphony.xwork2.ActionSupport;
import net.sdygt.jsp.login.model.User;

import java.sql.SQLException;

public class LoginAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private User userBean = new User();


    public String execute() throws Exception {
        try {
            if (userBean.query()) {
                return SUCCESS;
            } else {
                return LOGIN;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }

    }

    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }
}


