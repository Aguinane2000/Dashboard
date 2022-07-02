package com.example.textmining.dao;

import com.example.textmining.bean.MotCle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotCleDao extends JpaRepository<MotCle, Long> {

    @Query("SELECT m from MotCle m ")
    public List<MotCle> findAllMotCles();


    @Query("SELECT item.motCle FROM MotCleItem item WHERE item.paragraphe.corps = :p")
    public List<MotCle> findByParagrapheCorps(@Param("p") String paragraphe);

    @Query("SELECT fre.motcle FROM Frequence fre WHERE fre.article.texte = :t")
    public List<MotCle> findByArticleTitre(@Param("t") String titre);


    MotCle findByLibelle(String mot);

    int deleteByLibelle(String mot);

}
