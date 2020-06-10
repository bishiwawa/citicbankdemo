package com.example.hello.controller;

import com.example.hello.service.ICardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 银行卡相关业务控制器
 *
 * @author ld
 * @date 2020.6.10
 * */
@Controller
@RequestMapping("/card")
public class CardController {
    @Resource
    private ICardService cardService;

    @RequestMapping("/opencard")
    @ResponseBody
    public void openCard(){
        cardService.openCard(121);
    }

    @RequestMapping("/cancelcard")
    @ResponseBody
    public void cancelCard(){
        cardService.cancelCard(121);
    }
}
