package com.example.textmining.service.impl;


import com.example.textmining.bean.Article;
import com.example.textmining.bean.Frequence;
import com.example.textmining.dao.FrequenceDao;
import com.example.textmining.service.facade.ArticleService;
import com.example.textmining.service.facade.FrequenceService;
import com.example.textmining.service.vo.FrequenceMotVo;
import com.example.textmining.service.vo.SlideVo;
import com.example.textmining.util.SearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class FrequenceServiceImpl implements FrequenceService {

    @Autowired
    private FrequenceDao frequenceDao;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private EntityManager entityManager;

    public List<FrequenceMotVo> frequenceMotVos;
    public SlideVo slideVo;
    public List<SlideVo> slideVos = new ArrayList<>();


    @Override
    public List<SlideVo> findByMotcleLibelleAndArticleTitre(String libelle) {
        List<Article> articles = this.articleService.findByMotCleLibelle(libelle);
           slideVos = new ArrayList<>();
        for (Article article : articles) {
            List<Frequence> frequences = findByArticleId(article.getId());
            frequenceMotVos = new ArrayList<>();
            for (Frequence frequence : frequences) {
                FrequenceMotVo frequenceMotVo = new FrequenceMotVo(frequence.getMotcle().getMot(), frequence.getfrequence());
                frequenceMotVos.add(frequenceMotVo);

            }
            slideVo = new SlideVo(article, frequenceMotVos);
            slideVos.add(slideVo);
        }
        return slideVos;
    }



    @Override
    public List<FrequenceMotVo> MaxFrequence(){
         String query="select new  com.example.textmining.service.vo.FrequenceMotVo(f.motcle.libelle,f.frequence) from Frequence f WHERE 1=1";
         query+= SearchUtil.addConstraint("f","frequence",">=",200);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Frequence> findByArticleId(Long id) {
        return frequenceDao.findByArticleId(id);
    }
}
