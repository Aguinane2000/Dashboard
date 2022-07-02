package com.example.textmining.service.impl;

import com.example.textmining.bean.Paragraphe;
import com.example.textmining.dao.ParagrapheDao;
import com.example.textmining.service.facade.ParagrapheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PragrapheServiceImpl implements ParagrapheService {

    @Autowired
    private ParagrapheDao paragrapheDao;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Paragraphe> findByMotCleLibelle(String mot) {
        String query = " SELECT item.paragraphe FROM MotCleItem item WHERE item.motCle.libelle ='" + mot + "'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Paragraphe> TenParagraphs() {
        String query = " SELECT p FROM Paragraphe p WHERE p.id < 50";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Paragraphe> findAll() {
        return paragrapheDao.findAll();
    }



    public List<BigDecimal> conterParagraphes() {
        String query = " SELECT COUNT(p.id) from Paragraphe p";
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Paragraphe> findByArticleTitre(String titre) {
        return paragrapheDao.findByArticleTitre(titre);
    }
}
