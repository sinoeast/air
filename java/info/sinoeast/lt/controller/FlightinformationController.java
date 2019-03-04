package info.sinoeast.lt.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import info.sinoeast.lt.bean.Flightinformation;
import info.sinoeast.lt.service.IFlightinformationService;
import info.sinoeast.lt.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FlightinformationController {
    //日期控件String-》date
    @InitBinder
    public void initBinder(WebDataBinder binder){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @Autowired
    IFlightinformationService flightinformationService;
    //获取航班信息并分页
    @RequestMapping("selectFlightinformation")
    @ResponseBody
    public Msg queryFlightinformation(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        //引入pageHelper插件,页码和行数
        PageHelper.startPage(pn,5);
        List<Flightinformation> list=flightinformationService.queryInformation();
        //包装查询后的结果,连续传入5页
        PageInfo page=new PageInfo(list,5);
        return Msg.success().add("pageInfo",page);
    }

    //新增航班信息
    @RequestMapping(value = "insertFliinfo",method = RequestMethod.POST)
    @ResponseBody
    public Msg insertFliinfo(@Valid Flightinformation flightinformation, BindingResult result ){

        System.out.print(flightinformation);
        if(result.hasErrors()){
            Map<String,Object> map=new HashMap<String, Object>();
            List<FieldError> error = result.getFieldErrors();
            for(FieldError fieldError:error){
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields",map);
        }else {
            flightinformationService.insertFliinfo(flightinformation);
            return Msg.success();
        }
    }
    //根据fliautoid查找航班信息
    @RequestMapping("selectfliinfoById")
    @ResponseBody
    public Msg selectfliinfoById(@RequestParam("fliAutoid") Integer id){
        Flightinformation flightinformation= flightinformationService.selectfliinfoById(id);
        return Msg.success().add("fliInfo_updata",flightinformation);
    }
    /*
        根据flino删除航班信息
     */

    @RequestMapping(value = "deleteone/{Flino}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteone(@PathVariable("Flino") String Flino){

        System.out.println("/////////////////////////////////////////////"+Flino);
        if(flightinformationService.deleteone(Flino)){
            return Msg.success();
        }else{
            return Msg.fail().add("va_mas","存在订单不能删除");
        }
    }
    //更新订单
    @RequestMapping(value = "updataFliInfo/{fliAutoid}",method = RequestMethod.POST)
    @ResponseBody
    public Msg updataFliInfo(Flightinformation flightinformation){

        System.out.println(flightinformation.getFliDiscount());
        flightinformationService.updataByPrimaryKeySelective(flightinformation);

        return Msg.success();

    }


}
