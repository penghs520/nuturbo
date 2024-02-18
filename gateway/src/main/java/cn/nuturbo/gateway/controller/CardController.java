package cn.nuturbo.gateway.controller;

import cn.nuturbo.card.api.CardRemoteService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by penghs at 2024/2/15 17:13
 */
@RestController
@RequestMapping("/api/v1/card")
public class CardController {

    @DubboReference
    private CardRemoteService cardRemoteService;

    @PostMapping("/create")
    public String create() {
        return "create card";
    }
}
