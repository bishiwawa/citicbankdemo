package com.example.hello.controller;

import com.example.hello.mapper.TransactionsMapper;
import com.example.hello.mapper.UserMapper;
import com.example.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class TransferMoneyController {
    @Autowired
    private TransactionsMapper transactionsMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String toIndexPage(){
        return "/index";
    }

    @GetMapping("/transfer")
    public String toTransPage(){
        return "/transfer/trans_page";
    }

    @PostMapping("/transfer")
    public String doTransfer(@RequestParam("src_card") String cardIdSrc,
                             @RequestParam("des_card") String cardIdDes,
                             @RequestParam("trans_money") BigDecimal transMoney,
                             Model model){
        //卡号不存在的情况
        int existSrc = userMapper.existByCardId(cardIdSrc);
        if(existSrc == 0){
            model.addAttribute("reminder", "转出银行卡不存在！");
            return "/transfer/trans_finish";
        }
        int existDes = userMapper.existByCardId(cardIdDes);
        if(existDes == 0){
            model.addAttribute("reminder", "转入银行卡不存在！");
            return "/transfer/trans_finish";
        }

        //钱不够的情况
        BigDecimal balanceSrc = userMapper.getBalanceByCardId(cardIdSrc);
        if(balanceSrc.compareTo(transMoney) == -1){
            model.addAttribute("reminder", "余额不足！");
            return "/transfer/trans_finish";
        }

        //钱够，开始转账！
        //事务的原子性
        try{
            userService.deal(cardIdSrc, cardIdDes, transMoney);
            //给trans表添加转账记录
            transactionsMapper.updateTransRecord(cardIdSrc, cardIdDes, transMoney);

            model.addAttribute("reminder", "转账成功！");
            return "/transfer/trans_finish";
        }catch (Exception e){
            model.addAttribute("reminder", "系统异常，转账失败！");
            return "/transfer/trans_finish";
        }
    }
}
