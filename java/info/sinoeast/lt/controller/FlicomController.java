package info.sinoeast.lt.controller;

import info.sinoeast.lt.bean.Flicom;
import info.sinoeast.lt.service.FlicomService;
import info.sinoeast.lt.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FlicomController {

    @Autowired
    FlicomService fliinfoService;

    @RequestMapping("flicom_info")
    @ResponseBody
    public Msg air_info(){
        List<Flicom> list=fliinfoService.selectInfo();
        return Msg.success().add("flicom",list);
    }
}
