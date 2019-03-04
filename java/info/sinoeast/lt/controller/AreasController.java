package info.sinoeast.lt.controller;

import info.sinoeast.lt.service.impl.AreasService;
import info.sinoeast.lt.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AreasController {
    @Autowired
    AreasService areasService;
    //查看areas对象是否已经存在是否,校验输入合法性
    @RequestMapping("selectareaName")
    @ResponseBody
    public Msg postEmp(@RequestParam("baadress") String address){
        //输入合法性校验
        System.out.print(address);
        String regex="^[\\u4e00-\\u9fa5]{0,}$";
        if(!address.matches(regex)){
            return Msg.fail().add("va_msg","只能输入汉字");
        }
        if(address==""){
            return Msg.fail().add("va_msg","不能为空");
        }else{
            boolean a=areasService.selectByareaName(address);
            if(a){
                return Msg.success().add("Areas",a);
            }else{
                return Msg.fail().add("va_msg","城市名有误或不存在");
            }
        }
    }
}
