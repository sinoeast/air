package info.sinoeast.lt.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import info.sinoeast.lt.bean.Bookinformation;
import info.sinoeast.lt.service.IBookinformationService;
import info.sinoeast.lt.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookinformationController {


    @Autowired
    IBookinformationService bookinformationService;
    /*
    查询订单数据（分页查询）
     */
    @RequestMapping("selectBookinformation")
    @ResponseBody
    public Msg queryinformation(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        //引入pageHelper插件,页码和行数
        PageHelper.startPage(pn,5);
        List<Bookinformation> list=bookinformationService.queryInformation();
        //包装查询后的结果,连续传入5页
        PageInfo page=new PageInfo(list,5);
        return Msg.success().add("pageInfo",page);
    }
}
