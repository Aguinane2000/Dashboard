package com.example.textmining.ws;

import com.example.textmining.bean.MotCle;
import com.example.textmining.service.facade.MotCleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/motcle")
@CrossOrigin( origins = {"http://localhost:4200"})
public class MotCleRest {

    @Autowired
    private MotCleService motCleService;


    @GetMapping("/article/titre/{titre}")
    public List<MotCle> findByArticleTitre( @PathVariable String titre) {
        return motCleService.findByArticleTitre(titre);
    }

    @GetMapping("/paragraphe/{paragraphe}")
    public List<MotCle> findByParagrapheCorps( @PathVariable String paragraphe) {
        return motCleService.findByParagrapheCorps(paragraphe);
    }

    @GetMapping("/")
    public List<MotCle> findAllMotCles() {
        return motCleService.findAllMotCles();
    }

    @GetMapping("/count")
    public List<BigDecimal> conterMotCles() {
        return motCleService.conterMotCles();
    }

    @GetMapping("/mot/{mot}")
    public MotCle findByMot(@PathVariable String mot) {
        return motCleService.findByMot(mot);
    }

    @DeleteMapping("/mot/{mot}")
    public int deleteByMot( @PathVariable String mot) {
        return motCleService.deleteByMot(mot);
    }
}
