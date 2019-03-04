package info.sinoeast.lt.controller;


import info.sinoeast.lt.service.IManagerService;
import info.sinoeast.lt.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ManagerController {

    @Autowired
    IManagerService managerService;
    /*
    管理员登陆
     */
    @RequestMapping("manlogin")
    @ResponseBody
    public Msg man_login(HttpSession session, @RequestParam("manAccount") String manAccount, @RequestParam("manPwd")String manPwd){
        System.out.println(manAccount);
        System.out.println(manPwd);
        if(manAccount.equals("")||manPwd.equals("")){
            return Msg.fail().add("login_msg","账户或密码不能为空");
        }
        boolean b=managerService.loginManager(manAccount,manPwd);
        if (b){
            session.setAttribute("manAccount",manAccount);
            return Msg.success() ;
        }else {
            return Msg.fail().add("login_msg","账户或密码有误");
        }
    }
    @RequestMapping("TPS")
    public String TPS(){
        return "TPS";
    }
}
