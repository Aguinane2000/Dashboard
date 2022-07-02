package com.example.textmining.service.facade;

import com.example.textmining.bean.MotCle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface MotCleService {

    @Query("SELECT fre.motcle FROM Frequence fre WHERE fre.article.texte = :a")
    List<MotCle> findByArticleTitre(String titre);

    List<MotCle> findByParagrapheCorps(String paragraphe);

    List<MotCle> findAllMotCles();

    List<BigDecimal> conterMotCles();

    MotCle findByMot(String mot);

    @Transactional
    int deleteByMot(String mot);
}
