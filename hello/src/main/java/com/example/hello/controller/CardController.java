package com.example.hello.controller;

import com.example.hello.po.CardVO;
import com.example.hello.po.Status;
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

    private CardVO convertToHtml(Status rs){
        CardVO cardVO = new CardVO();
        if(rs.equals(Status.OK)){
            cardVO.setCode(1);
            return cardVO;
        }else if(rs.equals(Status.NO_AUTHORITY)){
            cardVO.setCode(2);
        }
        //走到这里说明服务器异常
        cardVO.setCode(3);
        return cardVO;
    }

    @RequestMapping("/opencard")
    @ResponseBody
    public CardVO openCard(){
        Status rs = cardService.openCard(121);
        return convertToHtml(rs);
    }

    @RequestMapping("/cancelcard")
    @ResponseBody
    public CardVO cancelCard(){
        Status rs = cardService.cancelCard(121);
        return convertToHtml(rs);
    }
}
