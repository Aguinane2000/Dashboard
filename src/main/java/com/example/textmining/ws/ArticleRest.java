package com.example.textmining.ws;

import com.example.textmining.bean.Article;
import com.example.textmining.service.facade.ArticleService;
import com.example.textmining.service.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/article")
@CrossOrigin( origins = {"http://localhost:4200"})
public class ArticleRest {

    @Autowired
    private ArticleService articleService;


    @GetMapping("/motcle/libelle/{libelle}")
    public List<Article> findByMotCleLibelle( @PathVariable String libelle) {
        return articleService.findByMotCleLibelle(libelle);
    }

    @GetMapping("/conter-articles-par-mois/{annee}")
    public List<BigDecimal> conterArticlesParMois( @PathVariable Integer annee) {
        return articleService.conterArticlesParMois(annee);
    }

    @GetMapping("/calculer-pourcentage-signe")
    public List<SignePourcentageVo> calculerPourcentageSigne() {
        return articleService.calculerPourcentageSigne();
    }

    @GetMapping("/conter-journalistes")
    public List<Long> conterJournalistes() {
        return articleService.conterJournalistes();
    }

    @GetMapping("/calculer-positivite-par-mois/annee/{annee}")
    public List<PositiviteMoisVo> calculerPositiviteParMois(@PathVariable Integer annee) {
        return articleService.calculerPositiviteParMois(annee);
    }

    @GetMapping("/conter-articles-journaliste-par-mois/annee/mois/{annee}/{mois}")
    public List<ArticleJournalisteVo> conterArticlesJournalisteParMois( @PathVariable Integer annee,@PathVariable Integer mois) {
        return articleService.conterArticlesJournalisteParMois(annee, mois);
    }

    @GetMapping("/calculer-positivite-articles-journaliste-par-mois/annee/mois/{annee}/{mois}")
    public List<PositiviteJournalisteMoisVo> calculerPositiviteArticlesJournalisteParMois(@PathVariable Integer annee,@PathVariable Integer mois) {
        return articleService.calculerPositiviteArticlesJournalisteParMois(annee, mois);
    }

    @GetMapping("/calculer-pourcentage-article-j/annee/{annee}")
    public List<PourcentageArticleJVo> calculerPourcentageArticleJ( @PathVariable Integer annee) {
        return articleService.calculerPourcentageArticleJ(annee);
    }

    @GetMapping("/journalistes")
    public List<String> findAllJournalistes() {
        return articleService.findAllJournalistes();
    }


    @GetMapping("/conter-articles")
    public List<BigDecimal> conterArticles() {
        return articleService.conterArticles();
    }

    @GetMapping("/titre/{titre}")
    public Article findByTitre(@PathVariable String titre) {
        return articleService.findByTitre(titre);
    }


/*
    @DeleteMapping("/titre/{titre}")
    public int deleteByTitre(@PathVariable String titre) {
        return articleService.deleteByTitre(titre);
    }

    @GetMapping("/journaliste/{journaliste}")
    public List<Article> findByJournaliste(@PathVariable String journaliste) {
        return articleService.findByJournaliste(journaliste);
    }

    @GetMapping("/conter-articles-par-mois/{annee}")
    public List<BigDecimal> conterArticleParMois( @PathVariable int annee) {
        return articleService.conterArticleParMois(annee);
    }

    @DeleteMapping("/journaliste/{journaliste}")
    public int deleteByJournaliste(@PathVariable String journaliste) {
        return articleService.deleteByJournaliste(journaliste);
    }


    @GetMapping("/positivite/{positivite}")
    public List<Article> findByPositivite(@PathVariable Double positivite) {
        return articleService.findByPositivite(positivite);
    }


    @DeleteMapping("/positivite/{positivite}")
    public int deleteByPositivite(@PathVariable Double positivite) {
        return articleService.deleteByPositivite(positivite);
    }*/
}
