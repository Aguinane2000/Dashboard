package com.example.textmining.service.facade;

import com.example.textmining.bean.Article;
import com.example.textmining.service.vo.*;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface ArticleService {


    List<Article> findByMotCleLibelle(String mot);

    List<BigDecimal> conterArticlesParMois(Integer annee);


    List<SignePourcentageVo> calculerPourcentageSigne();

    List<String> findAllJournalistes();

    List<Long> conterJournalistes();

    List<PositiviteMoisVo> calculerPositiviteParMois(Integer annee);

    List<PourcentageArticleJVo> calculerPourcentageArticleJ(Integer annee);

    List<ArticleJournalisteVo>
    conterArticlesJournalisteParMois( Integer annee ,Integer mois );

    List<PositiviteJournalisteMoisVo> calculerPositiviteArticlesJournalisteParMois(Integer annee, Integer mois);

    List<BigDecimal> conterArticles();

    Article findByTitre(String titre);

    @Transactional
    int deleteByTitre(String titre);

    List<Article> findByJournaliste(String journaliste);

    @Transactional
    int deleteByJournaliste(String journaliste);

    List<Article> findByPositivite(double positivite);

    @Transactional
    int deleteByPositivite(double positivite);
}

