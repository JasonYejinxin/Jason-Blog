package jason.springframework.jasonblog.interceptor;

import jason.springframework.jasonblog.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BackInterceptor implements HandlerInterceptor {
    private static String uname = "jinxinye";
    private static String password = "1997921";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response) throws Exception{
        boolean flag = true;
        User user = (User)request.getSession().getAttribute("user");
        if(null == user){
            flag = false;
        }else{
            if(user.getUname().equals(uname) && user.getPassword().equals(password)){
                flag = true;
            }
            else {
                flag = false;
            }
        }
        return flag;
    }
}
