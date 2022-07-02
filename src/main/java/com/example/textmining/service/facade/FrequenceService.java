package com.example.textmining.service.facade;

import com.example.textmining.bean.Frequence;
import com.example.textmining.service.vo.FrequenceMotVo;
import com.example.textmining.service.vo.SlideVo;

import java.util.List;

public interface FrequenceService {
    List<SlideVo> findByMotcleLibelleAndArticleTitre(String libelle);

    List<FrequenceMotVo> MaxFrequence();

    List<Frequence> findByArticleId(Long id);
}
