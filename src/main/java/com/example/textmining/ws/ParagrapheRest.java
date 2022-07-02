package com.example.textmining.ws;

import com.example.textmining.bean.Paragraphe;
import com.example.textmining.service.facade.ParagrapheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/paragraphe")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ParagrapheRest {

    @Autowired
    private ParagrapheService paragrapheService;


    @GetMapping("/mot/{mot}")
    public List<Paragraphe> findByMotCleLibelle(@PathVariable String mot) {
        return paragrapheService.findByMotCleLibelle(mot);
    }

    @GetMapping("/")
    public List<Paragraphe> findAll() {
        return paragrapheService.findAll();
    }

    @GetMapping("/ten")
    public List<Paragraphe> TenParagraphs() {
        return paragrapheService.TenParagraphs();
    }

    @GetMapping("/count")
    public List<BigDecimal> conterParagraphes() {
        return paragrapheService.conterParagraphes();
    }

    @GetMapping("/article/titre/{titre}")
    public List<Paragraphe> findByArticleTitre(@PathVariable String titre) {
        return paragrapheService.findByArticleTitre(titre);
    }
}
