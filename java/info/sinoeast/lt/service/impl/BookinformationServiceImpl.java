package info.sinoeast.lt.service.impl;

import info.sinoeast.lt.bean.Bookinformation;
import info.sinoeast.lt.mapper.BookinformationMapper;
import info.sinoeast.lt.service.IBookinformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookinformationServiceImpl implements IBookinformationService {


    @Autowired
    BookinformationMapper bookinformationMapper;
    @Override
    public List<Bookinformation> queryInformation() {
        return bookinformationMapper.queryInformation();
    }
}
