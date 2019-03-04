package info.sinoeast.lt.service;

public interface IManagerService {
    /*
    login
    p：account；
    r：pwd
     */
    public boolean loginManager(String manAccount,String manPwd);
}
