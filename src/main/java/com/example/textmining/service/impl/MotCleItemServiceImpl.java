package com.example.textmining.service.impl;


import com.example.textmining.bean.MotCleItem;
import com.example.textmining.dao.MotCleItemDao;
import com.example.textmining.service.facade.MotCleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MotCleItemServiceImpl implements MotCleItemService {

    @Autowired
    private MotCleItemDao motCleItemDao;


    @Override
    public List<MotCleItem> findByMotCleLibelle(String mot) {
        return motCleItemDao.findByMotCleLibelle(mot);
    }

    @Override
    @Transactional
    public int deleteByMotCleLibelle(String mot) {
        return motCleItemDao.deleteByMotCleLibelle(mot);
    }
}
