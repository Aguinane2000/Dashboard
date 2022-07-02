package com.example.textmining.dao;

import com.example.textmining.bean.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ArticleDao extends JpaRepository< Article , Long> {

     @Query("select a from Article a")
     List<Article> findAllArticles();

     @Query("select count(a.id) from Article a where a.annee = :y  group by a.mois   ")
     List<BigDecimal> conterArticleParMoisQ(@Param("y") int annee);

     @Query("select distinct journaliste from Article ")
     List<String> findAllJournalistes();

     @Query("select  a from Article a where a.journaliste = :j ")
     List<Article> findAllArticlesJournaliste( @Param("j") String journaliste);

     Article findByTitre(String titre);
     int deleteByTitre(String titre);
     List<Article> findByJournaliste(String journaliste);
     int deleteByJournaliste(String journaliste);
     List<Article> findByPositivite(double positivite);
     int deleteByPositivite(double positivite);


}
