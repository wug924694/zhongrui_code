package com.zhongrui.goods.controller;

import com.github.pagehelper.PageInfo;
import com.zhongrui.entity.Result;
import com.zhongrui.entity.StatusCode;
import com.zhongrui.goods.pojo.Spu;
import com.zhongrui.goods.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/spu")
@CrossOrigin
public class SpuController {

    @Autowired
    private SpuService spuService;

    /***
     * Spu分页条件搜索实现
     * @param spu
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  Spu spu, @PathVariable  int page, @PathVariable  int size){
        //调用SpuService实现分页条件查询Spu
        PageInfo<Spu> pageInfo = spuService.findPage(spu, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Spu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SpuService实现分页查询Spu
        PageInfo<Spu> pageInfo = spuService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param spu
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Spu>> findList(@RequestBody(required = false)  Spu spu){
        //调用SpuService实现条件查询Spu
        List<Spu> list = spuService.findList(spu);
        return new Result<List<Spu>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SpuService实现根据主键删除
        spuService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Spu数据
     * @param spu
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  Spu spu,@PathVariable String id){
        //设置主键值
        spu.setId(id);
        //调用SpuService实现修改Spu
        spuService.update(spu);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Spu数据
     * @param spu
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   Spu spu){
        //调用SpuService实现添加Spu
        spuService.add(spu);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Spu数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Spu> findById(@PathVariable String id){
        //调用SpuService实现根据主键查询Spu
        Spu spu = spuService.findById(id);
        return new Result<Spu>(true,StatusCode.OK,"查询成功",spu);
    }

    /***
     * 查询Spu全部数据
     * @return
     */
    @GetMapping
    public Result<List<Spu>> findAll(){
        //调用SpuService实现查询所有Spu
        List<Spu> list = spuService.findAll();
        return new Result<List<Spu>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
