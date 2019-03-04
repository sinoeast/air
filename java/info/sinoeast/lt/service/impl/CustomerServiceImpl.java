package info.sinoeast.lt.service.impl;

import info.sinoeast.lt.bean.Customer;
import info.sinoeast.lt.mapper.CustomerMapper;
import info.sinoeast.lt.service.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements Login {
    @Autowired
    CustomerMapper customerMapper;
    @Override
    public boolean login(String account, String pwd) {
        try{
            Customer list=customerMapper.loginCustomerBycusAcount(account);
            if(account.equals(list.getCusAccount())&&pwd.equals(list.getCusPwd())){
                return true;
            }else{
                return false;
            }
        }catch (NullPointerException e){
            return false;
        }
    }
    public boolean loginb(String telnumber, String pwd) {
        try{
            Customer list=customerMapper.loginCustomerByTelnumber(telnumber);
            if(telnumber.equals(list.getCusTelnumber())&&pwd.equals(list.getCusPwd())){
                return true;
            }else{
                return false;
            }
        }catch (NullPointerException e){
            return false;
        }
    }

}
