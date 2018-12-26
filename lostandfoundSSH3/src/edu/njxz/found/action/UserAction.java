package edu.njxz.found.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.njxz.found.entity.Message;
import edu.njxz.found.entity.User;
import edu.njxz.found.entity.vo.Post;
import edu.njxz.found.service.MessageService;
import edu.njxz.found.service.UserService;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;



@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {

    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    private String userName;
    private String password;

    //
    @Override
    public String execute() throws Exception {

        User user=new User();
        user.setUserName("kk");
        user.setUserPassword("123456");
        userService.saveUser(user);
        logger.info("保存成功");
        return SUCCESS;
    }

    /**
     * 用户登录
     * @return
     */
    public String userLogin() {
    	User user=userService.userLogin(userName, password);
    	if(null!=user) {
    		//获取Context对象
    		ActionContext context=ActionContext.getContext();
    		context.getSession().put("user", user);
    		
    	//	List<Message> messageList=messageService.findAll();
    		List<Post> postList=messageService.findAllPost();
//    		for(Post post:postList) {
//    			System.out.println(post.getUser().getUserName());
//    		}
    		context.put("postList", postList);
    		return SUCCESS;
    	}
    	return "fail";
    }

    /**
     * 用户注销
     * @return
     */
    public String userLogout() {
    	//获取Context对象
		ActionContext context=ActionContext.getContext();
		context.getSession().clear();
    	return "success";
    }
    
    /**
     * 用户注册
     * @return
     */
    public String userRegister() {
    	User user=new User();
    	user.setUserName(userName);
    	user.setUserPassword(password);
    	userService.saveUser(user);
    	return "success";
    }
    /**
     * 跳转到用户信息页
     * @return
     */
    public String toUserMsgPage() {
    	
    	return "success";
    }
    /**
     * 跳转到用户首页
     * @return
     */
    public String toIndexPage() {
    	//获取Context对象
		ActionContext context=ActionContext.getContext();
		
	//	List<Message> messageList=messageService.findAll();
		List<Post> postList=messageService.findAllPost();
//		for(Post post:postList) {
//			System.out.println(post.getUser().getUserName());
//		}
		context.put("postList", postList);
    	return "success";
    }
    
    /**
     * 跳转到用户发布信息页
     * @return
     */
    public String toSendPage() {
    	return "yes";
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
