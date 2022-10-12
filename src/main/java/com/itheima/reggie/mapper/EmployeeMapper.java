package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
/**
 * @author Sora
 * @Description
 * @Auther Terence Zhang
 * @Datetime 22/10/11 22:54
 **/
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
