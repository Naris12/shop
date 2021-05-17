package com.Shop.test.Controller;

import com.Shop.test.Service.ProductsService;
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

    private final ProductsService productsService;

    @GetMapping
    public String homepage(Model model){
        model.addAttribute("list",productsService.getallproduct());
        return "index";
    }
}
