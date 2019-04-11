package com.duoforcestudio.teamtable.contorller;


import com.duoforcestudio.teamtable.service.DrugInfoService;
import com.duoforcestudio.teamtable.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/drugInfo")
public class DrugInfoController {

    private static final Logger logger = LoggerFactory.getLogger(DrugInfoController.class);


    private DrugInfoService drugInfoService;


    @Autowired
    public DrugInfoController(DrugInfoService drugInfoService) {
        this.drugInfoService = drugInfoService;
    }



    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Response list(@RequestParam(value = "keyword", required = false) String keyword,
                         @RequestParam(value = "status", required = false) Integer status,
                         @RequestParam(value = "pageNo") Integer pageNo) {

        HashMap<String, Object> map;
        try {
            map = drugInfoService.list(keyword, status, pageNo);
        } catch (Exception e) {
            return Response.fail("查询失败!");
        }
        return Response.buildSuccess(map);
    }






}
