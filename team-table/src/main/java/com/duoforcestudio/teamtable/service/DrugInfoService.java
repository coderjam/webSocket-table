package com.duoforcestudio.teamtable.service;

import java.util.HashMap;

public interface DrugInfoService {


    HashMap<String, Object> list(String keyword, Integer status, Integer pageNo);
}
