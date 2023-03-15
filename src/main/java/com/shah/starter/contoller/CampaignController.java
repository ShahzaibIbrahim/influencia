package com.shah.starter.contoller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/campaign")
public class CampaignController {

    @PostMapping("/create")
    public String createCapmaign(Authentication authentication) {


        return "Campaign Created";
    }

}
