package com.duoforcestudio.teamtable.mapper;

import com.duoforcestudio.teamtable.entity.Drug;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DrugMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Drug record);

    int insertSelective(Drug record);

    Drug selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Drug record);

    int updateByPrimaryKey(Drug record);

    List<Drug> list(@Param("keyword") String keyword, @Param("pageNo") Integer pageNo,
                    @Param("pageSize") Integer pageSize);

    int findCount(@Param("keyword") String keyword);
}
