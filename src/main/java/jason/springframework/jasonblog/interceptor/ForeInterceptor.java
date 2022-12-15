package jason.springframework.jasonblog.interceptor;

import jason.springframework.jasonblog.dao.SysService;
import jason.springframework.jasonblog.entity.SysLog;
import jason.springframework.jasonblog.entity.SysView;
import jason.springframework.jasonblog.util.BrowserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class ForeInterceptor() implements HandlerInterceptor {
    @Autowired
    SysService sysService;

    private SysLog sysLog = new SysLog();
    private SysView sysView = new SysView();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
    // 访问者的IP
    String ip = request.getRemoteAddr();
    // 访问地址
    String url = request.getRequestURL().toString();
    //得到⽤户的浏览器名
    String userbrowser = BrowserUtil.getOsAndBrowserInfo(request);
    // 给SysLog增加字段
    sysLog.setIp(StringUtils.isEmpty(ip) ? "0.0.0.0" : ip);
    sysLog.setOperateBy(StringUtils.isEmpty(userbrowser) ? "获取浏览失败":userbrowser);
    sysLog.setOperateUrl(StringUtils.isEmpty(url) ? "获取URL失败" :url);
    // 增加访问量
    sysView.setIp(StringUtils.isEmpty(ip) ? "0.0.0.0" : ip);
    sysService.addView(sysView);
 return true;
}
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,Object handler, ModelAndView modelAndView){
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 保存⽇志信息
        sysLog.setRemark(method.getName());
        sysService.addLog(sysLog);
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e){
    }
}
