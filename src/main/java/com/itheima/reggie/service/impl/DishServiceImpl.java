package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.mapper.DishMapper;
import com.itheima.reggie.service.DishService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Auther Terence Zhang
 * @Datetime 22/10/20 22:11
 **/
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
