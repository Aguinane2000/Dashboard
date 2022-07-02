package com.example.textmining.service.vo;

import com.example.textmining.bean.Article;

import java.util.List;

public class SlideVo {
    public Article article ;
    public List<FrequenceMotVo> frequenceMots;

    public SlideVo() {
    }

    public SlideVo(Article article, List<FrequenceMotVo> frequenceMots) {
        this.article = article;
        this.frequenceMots = frequenceMots;
    }
}
