package com.example.textmining.service.facade;

import com.example.textmining.bean.MotCleItem;

import java.util.List;

public interface MotCleItemService {

    List<MotCleItem> findByMotCleLibelle(String mot);

    int deleteByMotCleLibelle(String mot);
}
