package com.duoforcestudio.teamtable.service.impl;


import com.duoforcestudio.teamtable.constant.Constant;
import com.duoforcestudio.teamtable.entity.Drug;
import com.duoforcestudio.teamtable.mapper.DrugMapper;
import com.duoforcestudio.teamtable.service.DrugInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DrugInfoServiceImpl implements DrugInfoService {


    private DrugMapper drugMapper;


    @Autowired
    public DrugInfoServiceImpl(DrugMapper drugMapper) {
        this.drugMapper = drugMapper;
    }

    @Override
    public HashMap<String, Object> list(String keyword, Integer status, Integer pageNo) {
        HashMap<String, Object> map = new HashMap<>();
        Integer pageSize = Constant.DEFAULT_PAGE_SIZE;
        map.put("pageNo", pageNo);
        map.put("pageSize", pageSize);
        pageNo = (pageNo - 1) * pageSize;
        List<Drug> drugInfo = drugMapper.list(keyword, pageNo, pageSize);
        int count = drugMapper.findCount(keyword);
        int total = count / pageSize;
        if (count % pageSize > 0) {
            total += 1;
        }
        map.put("total", total);
        map.put("count", count);
        map.put("list", drugInfo);
        return map;
    }
}
