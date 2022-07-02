package com.example.textmining.ws;


import com.example.textmining.bean.Frequence;
import com.example.textmining.service.facade.FrequenceService;
import com.example.textmining.service.vo.FrequenceMotVo;
import com.example.textmining.service.vo.SlideVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/frequence")
public class FrequenceRest {


    @Autowired
    FrequenceService frequenceService;


    @GetMapping("/maxfrequence")
    public List<FrequenceMotVo> MaxFrequence() {
        return frequenceService.MaxFrequence();
    }

    @GetMapping("/findbymotclelibelleandarticletitre/libelle/{libelle}")
    public List<SlideVo> findByMotcleLibelleAndArticleTitre(@PathVariable String libelle) {
        return frequenceService.findByMotcleLibelleAndArticleTitre(libelle);
    }

    @GetMapping("/article/id/{id}")
    public List<Frequence> findByArticleId(@PathVariable Long id) {
        return frequenceService.findByArticleId(id);
    }
}
