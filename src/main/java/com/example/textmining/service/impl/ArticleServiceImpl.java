package com.example.textmining.service.impl;

import com.example.textmining.bean.Article;
import com.example.textmining.dao.ArticleDao;
import com.example.textmining.service.facade.ArticleService;
import com.example.textmining.service.vo.*;
import com.example.textmining.util.SearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private EntityManager entityManager;





    @Override
    public List<Article> findByMotCleLibelle(String mot) {
        String query = " SELECT fre.article FROM Frequence fre WHERE fre.motcle.libelle ='" + mot + "'";
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public List<BigDecimal> conterArticlesParMois(Integer annee) {
        String query = " select count(a.id) from Article a WHERE 1=1 ";
        query += SearchUtil.addConstraint("a", "annee", "=", annee);
        query += " group by a.mois";
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public  List<SignePourcentageVo> calculerPourcentageSigne(){
        String query=" select new  com.example.textmining.service.vo.SignePourcentageVo( count(a.id)/7043 *100 , a.signe) from Article a where 1=1";
        query+="group by a.signe";
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();
    }




    @Override
    public List<String> findAllJournalistes() {
        return articleDao.findAllJournalistes();
    }


    @Override
    public List<Long> conterJournalistes() {
        String query = "select count(distinct a.journaliste) from Article a";
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public List<PositiviteMoisVo> calculerPositiviteParMois(Integer annee) {

        String query = ("select NEW com.example.textmining.service.vo.PositiviteMoisVo( SUM(a.positivite)/COUNT(a.id) ,a.mois) from Article a WHERE 1=1");
        query += SearchUtil.addConstraint("a", "annee", "=", annee);
        query += " group by a.mois";
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public List<PourcentageArticleJVo> calculerPourcentageArticleJ(Integer annee) {
        String query = "select new com.example.textmining.service.vo.PourcentageArticleJVo( count(a.id)/( select count(a.id) from Article a where 1=1";
        query += SearchUtil.addConstraint("a", "annee", "=", annee);
        query += " )*100, a.journaliste) from Article a WHERE 1=1";
        query += SearchUtil.addConstraint("a", "annee", "=", annee);
        query += " group by a.journaliste";
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<ArticleJournalisteVo> conterArticlesJournalisteParMois(Integer annee, Integer mois) {

        String query = " select new  com.example.textmining.service.vo.ArticleJournalisteVo( a.journaliste ,count(a.id)) from Article a WHERE 1=1";
        query += SearchUtil.addConstraint("a", "mois", "=", mois);
        query += SearchUtil.addConstraint("a", "annee", "=", annee);
        query += " group by a.journaliste";
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();

    }


    @Override
    public List<PositiviteJournalisteMoisVo> calculerPositiviteArticlesJournalisteParMois(Integer annee, Integer mois) {

        String query = " select NEW com.example.textmining.service.vo.PositiviteJournalisteMoisVo( SUM(a.positivite)/count(a.id), a.journaliste) from Article a WHERE 1=1 ";
        query += SearchUtil.addConstraint("a", "mois", "=", mois);
        query += SearchUtil.addConstraint("a", "annee", "=", annee);
        query += " group by a.journaliste";
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();

    }


    @Override
    public List<BigDecimal> conterArticles() {
        String query = " SELECT COUNT(a.id) from Article a";
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public Article findByTitre(String titre) {
        return articleDao.findByTitre(titre);
    }

    @Override
    @Transactional
    public int deleteByTitre(String titre) {
        return articleDao.deleteByTitre(titre);
    }

    @Override
    public List<Article> findByJournaliste(String journaliste) {
        return articleDao.findByJournaliste(journaliste);
    }

    @Override
    @Transactional
    public int deleteByJournaliste(String journaliste) {
        return articleDao.deleteByJournaliste(journaliste);
    }

    @Override
    public List<Article> findByPositivite(double positivite) {
        return articleDao.findByPositivite(positivite);
    }

    @Override
    @Transactional
    public int deleteByPositivite(double positivite) {
        return articleDao.deleteByPositivite(positivite);
    }


}

