package info.sinoeast.lt.mapper;

import info.sinoeast.lt.bean.Customer;

public interface CustomerMapper {
    /*
    通过账号登陆
     */
    Customer loginCustomerBycusAcount(String cusAccount);
    /*
    通过手机号登陆
     */
    Customer loginCustomerByTelnumber(String cusTelnumber);

}
