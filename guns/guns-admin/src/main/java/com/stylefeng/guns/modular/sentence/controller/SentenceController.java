package com.stylefeng.guns.modular.sentence.controller;

import com.stylefeng.guns.GunsApplication;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.sentence.Domain.Sentence;
import com.stylefeng.guns.modular.sentence.service.SentenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SentenceController extends BaseController{
    private SentenceService sentenceService;
    @Autowired
    public void setHskService(SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }
    private String PREFIX = "/sentence";
    private final static Logger logger = LoggerFactory.getLogger(GunsApplication.class);

    @RequestMapping(value="/sen1",method= RequestMethod.GET)
    public String HSK1(Model model){
        //logger.info(hskList.get(1).getWord());
        if (!model.containsAttribute("sentenceList")){
            List<Sentence> sentenceList = sentenceService.getSenList(1);
            model.addAttribute("sentenceList",sentenceList);
        }
        return PREFIX + "/sen1/sen1.html";
    }



}