package org.blue.dwbackendhive.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/*
 * @author Neo0214
 */
@Mapper
public interface TestMapper extends BaseMapper<Object> {

    @Select("select 1")
    public String test();
}
