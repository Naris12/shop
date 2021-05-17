package com.Shop.test.Controller;

import com.Shop.test.Service.ProductsService;
import com.Shop.test.Service.Userservice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@AllArgsConstructor
@Controller
@RequestMapping("/test")
public class TestController {
    private final Userservice userservice;
    private final ProductsService productsService;

    @GetMapping("/index")
    public String homepage(Model model){
       model.addAttribute("list",productsService.getallproduct());
        return "index";
    }

    @GetMapping("/userinfo")
    public String userpage(Model model){
        model.addAttribute("user",userservice.getalluser());
        return "userinfo";
    }
}
