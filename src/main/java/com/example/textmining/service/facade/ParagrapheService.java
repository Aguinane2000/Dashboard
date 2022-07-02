package com.example.textmining.service.facade;

import com.example.textmining.bean.Paragraphe;

import java.math.BigDecimal;
import java.util.List;

public interface ParagrapheService {

    List<Paragraphe> findByMotCleLibelle(String mot);

    List<Paragraphe> TenParagraphs();

    List<Paragraphe> findAll();

    List<BigDecimal> conterParagraphes();

    List<Paragraphe> findByArticleTitre(String titre);
}
