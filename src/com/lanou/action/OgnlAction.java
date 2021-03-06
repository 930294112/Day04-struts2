package com.lanou.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/10/13.
 */
public class OgnlAction extends ActionSupport {
    private String username; //表单提交的用户名
    private String password;  //表单提交的密码
    @Override
    public String execute() throws Exception {
        System.out.println(username + ":" + password);
        //获取当前请求对象的值栈
        ValueStack valueStack = ServletActionContext.getValueStack(ServletActionContext.getRequest());

        //1.在Request中的attr的map集合中存储数据
        ServletActionContext.getRequest().setAttribute("request_username","请求域中的属性");
        //2.往Application中的attr的map集合中存储数据
        ActionContext.getContext().getApplication().put("application_username","application对应的map集合中的存储数据");
        //3.往session中的map集合中存储数据
        ActionContext.getContext().getSession().put("session_username","session对应的map集合中的存储数据");
        //4.往parameter中的map集合存储数据,
        //parameters的集合中不能修改参数,往里面添加数据,但是取不到新加的数据,原因是一个请求的参数只能在第一次提交的时候设置,以后均不可变
        ActionContext.getContext().getParameters().put("parameter_username","parameter对应的map集合中的存储数据");

        //往request,session,application,中attr加同样名字的属性
        ServletActionContext.getRequest().setAttribute("name","request的");
        ServletActionContext.getRequest().getSession().setAttribute("name","session的");
        ServletActionContext.getServletContext().setAttribute("name","application的");
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
