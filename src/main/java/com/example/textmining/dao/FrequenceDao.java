package com.example.textmining.dao;

import com.example.textmining.bean.Frequence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FrequenceDao extends JpaRepository<Frequence,Long> {

     List<Frequence> findByArticleId(Long id);
}
