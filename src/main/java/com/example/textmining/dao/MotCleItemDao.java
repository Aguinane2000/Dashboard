package com.example.textmining.dao;

import com.example.textmining.bean.MotCleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotCleItemDao  extends JpaRepository<MotCleItem,Long> {

    List<MotCleItem> findByMotCleLibelle( String mot );
    int deleteByMotCleLibelle( String mot );
}
