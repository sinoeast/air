package info.sinoeast.lt.controller;

import info.sinoeast.lt.bean.AirType;
import info.sinoeast.lt.service.AirInfoService;
import info.sinoeast.lt.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AirCOntroller {

    @Autowired
    AirInfoService airInfoService;

    @RequestMapping("air_info")
    @ResponseBody
    public Msg air_info(){
        List<AirType> list=airInfoService.selectInfo();
        return Msg.success().add("airInfo",list);
    }
}
