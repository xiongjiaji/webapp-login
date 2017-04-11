package com.kyle.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Xiong on 2017/4/11.
 */
@Controller
public class BaseController {

    private static final String VIEW_INDEX = "index";

    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        return VIEW_INDEX;
    }

}
