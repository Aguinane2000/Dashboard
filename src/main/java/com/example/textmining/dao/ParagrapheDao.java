package com.example.textmining.dao;

import com.example.textmining.bean.Paragraphe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParagrapheDao  extends JpaRepository<Paragraphe, Long> {

    @Query("select p from Paragraphe p")
    public List<Paragraphe> findAll();

    List<Paragraphe> findByArticleTitre (String titre) ;
}
