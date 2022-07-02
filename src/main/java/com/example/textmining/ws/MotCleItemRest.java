package com.example.textmining.ws;

import com.example.textmining.bean.MotCleItem;
import com.example.textmining.service.facade.MotCleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/motcleitem")
@CrossOrigin( origins = {"http://localhost:4200"})
public class MotCleItemRest {

    @Autowired
    private MotCleItemService motCleItemService ;

    @GetMapping("/mot/{mot}")
    public List<MotCleItem> findByMotCleLibelle( @PathVariable String mot) {
        return motCleItemService.findByMotCleLibelle(mot);
    }

    @DeleteMapping("/mot/{mot}")
    public int deleteByMotCleLibelle( @PathVariable String mot) {
        return motCleItemService.deleteByMotCleLibelle(mot);
    }
}
