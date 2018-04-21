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
import org.springframework.web.bind.annotation.PathVariable;
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
    private String PREFIX = "/vocabulary";
    private final static Logger logger = LoggerFactory.getLogger(GunsApplication.class);

    @RequestMapping(value="/hsk1",method= RequestMethod.GET)
    public String HSK1(Model model){
        //logger.info(hskList.get(1).getWord());
        if (!model.containsAttribute("hskList")){
            List<HSK> hskList = hskService.getHSKList(1);
            model.addAttribute("hskList",hskList);
        }
        return PREFIX + "/hsk1/hsk1.html";
    }

    @RequestMapping(value="/hsk1_add",method= RequestMethod.GET)
    public String HSK1AddPage(){
        return PREFIX + "/hsk1/hsk1_add.html";
    }
    @RequestMapping(value="/hsk1_add",method= RequestMethod.POST)
    public String HSK1Add(String id ,String level, String word ,String pronunciation,String definition,String mp3){
        int id_1 = Integer.parseInt(id);
        int level_1= Integer.parseInt(level);
        HSK hsk =new HSK();
        hsk.setId(id_1);
        hsk.setLevel(level_1);
        hsk.setWord(word);
        hsk.setPronunciation(pronunciation);
        hsk.setDefinition(definition);
        hsk.setMp3(mp3);
        hskService.insertHSK(hsk);
        return REDIRECT + "/hsk1";
    }
//HSK1删除数据
    @RequestMapping(value="/hsk1//{id}",method= RequestMethod.GET)
    public String HSK1Delete(Model model, @PathVariable("id") Integer id){
        //logger.info(hskList.get(1).getWord());
        hskService.deleteHSKById(id);
        return REDIRECT + "/hsk1";
    }

    @RequestMapping(value="/hsk3",method= RequestMethod.GET)
    public String HSK3(Model model){
        //logger.info(hskList.get(1).getWord());
        if (!model.containsAttribute("hskList")){
            List<HSK> hskList = hskService.getHSKList(3);
            model.addAttribute("hskList",hskList);
        }
        return PREFIX + "/hsk3/hsk3.html";
    }
    @RequestMapping(value="/hsk4",method= RequestMethod.GET)
    public String HSK4(Model model){
        //logger.info(hskList.get(1).getWord());
        if (!model.containsAttribute("hskList")){
            List<HSK> hskList = hskService.getHSKList(4);
            model.addAttribute("hskList",hskList);
        }
        return PREFIX + "/hsk4/hsk4.html";
    }
    @RequestMapping(value="/hsk5",method= RequestMethod.GET)
    public String HSK5(Model model){
        //logger.info(hskList.get(1).getWord());
        if (!model.containsAttribute("hskList")){
            List<HSK> hskList = hskService.getHSKList(5);
            model.addAttribute("hskList",hskList);
        }
        return PREFIX + "/hsk5/hsk5.html";
    }
    @RequestMapping(value="/hsk6",method= RequestMethod.GET)
    public String HSK6(Model model){
        //logger.info(hskList.get(1).getWord());
        if (!model.containsAttribute("hskList")){
            List<HSK> hskList = hskService.getHSKList(6);
            model.addAttribute("hskList",hskList);
        }
        return PREFIX + "/hsk6/hsk6.html";
    }



}