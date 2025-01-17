package com.zhongrui.order.service;

import com.github.pagehelper.PageInfo;
import com.zhongrui.order.pojo.ReturnOrderItem;

import java.util.List;

/****
 * @Author:admin
 * @Description:ReturnOrderItem业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ReturnOrderItemService {

    /***
     * ReturnOrderItem多条件分页查询
     * @param returnOrderItem
     * @param page
     * @param size
     * @return
     */
    PageInfo<ReturnOrderItem> findPage(ReturnOrderItem returnOrderItem, int page, int size);

    /***
     * ReturnOrderItem分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<ReturnOrderItem> findPage(int page, int size);

    /***
     * ReturnOrderItem多条件搜索方法
     * @param returnOrderItem
     * @return
     */
    List<ReturnOrderItem> findList(ReturnOrderItem returnOrderItem);

    /***
     * 删除ReturnOrderItem
     * @param id
     */
    void delete(String id);

    /***
     * 修改ReturnOrderItem数据
     * @param returnOrderItem
     */
    void update(ReturnOrderItem returnOrderItem);

    /***
     * 新增ReturnOrderItem
     * @param returnOrderItem
     */
    void add(ReturnOrderItem returnOrderItem);

    /**
     * 根据ID查询ReturnOrderItem
     * @param id
     * @return
     */
     ReturnOrderItem findById(String id);

    /***
     * 查询所有ReturnOrderItem
     * @return
     */
    List<ReturnOrderItem> findAll();
}
