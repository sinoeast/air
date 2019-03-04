package info.sinoeast.lt.service.impl;

import info.sinoeast.lt.bean.Areas;
import info.sinoeast.lt.mapper.AreasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreasService {
    @Autowired
    AreasMapper areasMapper;
    public boolean selectByareaName(String AreaName){
        try{
            Areas a=areasMapper.selectAreasname(AreaName);
            if(AreaName.equals(a.getAreaName())){
                return true;
            }else{
                return false;
            }
        }catch (NullPointerException e){
            return false;
        }
    }
}
