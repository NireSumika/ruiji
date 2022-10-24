package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Auther Terence Zhang
 * @Datetime 22/10/19 22:59
 **/
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * @name save
     * @description 新增分类
     * @author Sora
     * @param:
     * @DateTime 22/10/20 21:18
     * @return:
     * @throws
     */
    @PostMapping
    public R<String> save(@RequestBody Category category){
        categoryService.save(category);
        log.info("Category:{}", category);
        return R.success("新增分类成功");
    }

    /**
     * @name page
     * @description 分类分页查询
     * @author Sora
     * @param:
     * @DateTime 22/10/20 21:58
     * @return:
     * @throws
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize){
        //分页构造器
        Page<Category> pageInfo = new Page<>(page, pageSize);
        //条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //添加排序条件，根据sort进行排序
        queryWrapper.orderByAsc(Category::getSort);

        //分页查询
        categoryService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }
    @DeleteMapping
    public R<String> delete(Long ids){
        log.info("删除分类, id:{}", ids);
        // categoryService.removeById(ids);
        categoryService.remove(ids);
        return R.success("分类信息删除成功");
    }

    /**
     * @name update
     * @description 根据id修改分类信息
     * @author Sora
     * @param:
     * @DateTime 22/10/20 22:39
     * @return:
     * @throws
     */
    @PutMapping
    public R<String> update(@RequestBody Category category){
        log.info("修改分类信息：{}", category);
        categoryService.updateById(category);
        return R.success("修改分类信息成功!");
    }

    @GetMapping("/list")
    public R<List<Category>> categoryList(Category category){
        log.info(category.toString());
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(category.getType() != null, Category::getType, category.getType());
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);

        List<Category> list = categoryService.list(queryWrapper);

        return R.success(list);
    }

}
