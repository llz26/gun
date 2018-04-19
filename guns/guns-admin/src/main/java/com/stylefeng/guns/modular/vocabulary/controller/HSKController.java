package com.stylefeng.guns.modular.vocabulary.controller;

import com.stylefeng.guns.GunsApplication;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.vocabulary.Domain.HSK;
import com.stylefeng.guns.modular.vocabulary.service.HSKService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HSKController extends BaseController{
    private HSKService hskService;
    @Autowired
    public void setHskService(HSKService hskService) {
        this.hskService = hskService;
    }
    private String PREFIX = "/vocabulary/hsk1/";
    private final static Logger logger = LoggerFactory.getLogger(GunsApplication.class);

    @RequestMapping(value="/hsk1",method= RequestMethod.GET)
    public String index(Model model){
        //logger.info(hskList.get(1).getWord());
        if (!model.containsAttribute("hskList")){
            List<HSK> hskList = hskService.getHskList(1);
            model.addAttribute("hskList",hskList);
        }
        return PREFIX + "hsk1.html";
    }
}