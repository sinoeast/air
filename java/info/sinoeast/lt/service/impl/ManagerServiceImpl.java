package info.sinoeast.lt.service.impl;

import info.sinoeast.lt.bean.Manager;
import info.sinoeast.lt.mapper.ManagerMapper;
import info.sinoeast.lt.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements IManagerService {
    @Autowired
    ManagerMapper managerMapper;

    @Override
    public boolean loginManager(String manAccount, String manPwd) {
        try{
            Manager list=managerMapper.loginManager(manAccount);
            if(manAccount.equals(list.getManAccount())&&manPwd.equals(list.getManPwd())){
                return true;
            }else{
                return false;
            }
        }catch (NullPointerException e){
            return false;
        }

    }

}
