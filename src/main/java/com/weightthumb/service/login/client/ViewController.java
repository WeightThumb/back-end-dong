package com.weightthumb.service.login.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@CrossOrigin
public class ViewController {
    @GetMapping("kakao")
    public String indexPage() {
        return "index";
    }
}
