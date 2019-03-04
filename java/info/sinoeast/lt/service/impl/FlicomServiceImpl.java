package info.sinoeast.lt.service.impl;

import info.sinoeast.lt.bean.Flicom;
import info.sinoeast.lt.bean.Flightinformation;
import info.sinoeast.lt.mapper.FlicomMapper;
import info.sinoeast.lt.service.FlicomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlicomServiceImpl implements FlicomService {
    @Autowired
    FlicomMapper flicom;
    @Override
    public List<Flicom> selectInfo() {
        return flicom.flicomInfo();
    }

    public void insertFliinfo(Flightinformation flightinformation){
        flicom.insertFliinfo(flightinformation);
    }

}
