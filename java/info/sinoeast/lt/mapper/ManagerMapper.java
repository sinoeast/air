package info.sinoeast.lt.mapper;

import info.sinoeast.lt.bean.Manager;

public interface ManagerMapper {
    /*
    登陆管理员账户
     */
    Manager loginManager(String manAccount);
}
