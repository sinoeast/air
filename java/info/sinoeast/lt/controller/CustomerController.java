package info.sinoeast.lt.controller;

import info.sinoeast.lt.service.Login;
import info.sinoeast.lt.service.impl.CustomerServiceImpl;
import info.sinoeast.lt.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class CustomerController {

    @Autowired
    Login login;
    @Autowired
    CustomerServiceImpl customerService;

    /*
    登陆验证用户名密码
     */
    @RequestMapping("loginCus")
    @ResponseBody
    public Msg login(HttpServletResponse response,HttpSession session, @RequestParam("Account") String Account, @RequestParam("cusPwd")String cusPwd){
        System.out.println(Account);
        System.out.println(cusPwd);
        String pn="^[1][34578]\\d{9}$";
        if(Account.equals("")||cusPwd.equals("")){
            return Msg.fail().add("login_msg","账户或密码不能为空");
        }
        if(Account.matches(pn)){
            boolean b=customerService.loginb(Account,cusPwd);
            if(b){
                Cookie c1=new Cookie("Account",Account);
                c1.setMaxAge(60*60*24*7);
                response.addCookie(c1);
                session.setAttribute("Account",Account);
                return Msg.success();
            }else {
                return Msg.fail().add("login_msg","账户或密码错误");
            }
        }else{
            boolean b=login.login(Account,cusPwd);
            if(b){
                session.setAttribute("Account",Account);
                return Msg.success();
            }else {
                return Msg.fail().add("login_msg","账户或密码错误");
            }
        }
    }
    /*
    推出登陆
     */
    @RequestMapping("/cust_logout")
    public void customerlogout(HttpServletRequest req, HttpServletResponse response) throws IOException {
        req.getSession().removeAttribute("Account");
        response.getWriter().write("");
    }
}
