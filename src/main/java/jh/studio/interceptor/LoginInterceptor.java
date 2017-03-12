package jh.studio.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		  String actionName=invocation.getProxy().getActionName();
	        if("admin".equals(actionName)){
	            return invocation.invoke();
	        }
		Object loginUserName = ActionContext.getContext().getSession().get("username");
        if(null  == loginUserName){
            return  Action.LOGIN;  // 这里返回用户登录页面视图
        }
        return invocation.invoke();
	}



}
