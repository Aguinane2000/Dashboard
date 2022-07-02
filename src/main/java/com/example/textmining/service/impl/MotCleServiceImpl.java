package com.example.textmining.service.impl;

import com.example.textmining.bean.MotCle;
import com.example.textmining.dao.MotCleDao;
import com.example.textmining.service.facade.MotCleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Service
public class MotCleServiceImpl implements MotCleService {

    @Autowired
    private MotCleDao motCleDao;

    @Autowired
    private EntityManager entityManager;


    /*@Override
    public List<MotCle> findByParagrapheCorps(String paragraphe) {
        String query = " SELECT item.motCle FROM MotCleItem item WHERE item.paragraphe.corps like '" + paragraphe + "'";
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();
    }*/

    @Override

    public List<MotCle> findByArticleTitre(String titre) {
        return motCleDao.findByArticleTitre(titre);
    }

    @Override
    public List<MotCle> findByParagrapheCorps(String paragraphe) {
        return motCleDao.findByParagrapheCorps(paragraphe);
    }

    @Override
    public List<MotCle> findAllMotCles() {
        return motCleDao.findAllMotCles();
    }


    @Override
    public List<BigDecimal> conterMotCles() {
        String query = " SELECT COUNT(m.id) from MotCle m";
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public MotCle findByMot(String mot) {
        return motCleDao.findByLibelle(mot);
    }

    @Override
    @Transactional
    public int deleteByMot(String mot) {
        return motCleDao.deleteByLibelle(mot);
    }


}
