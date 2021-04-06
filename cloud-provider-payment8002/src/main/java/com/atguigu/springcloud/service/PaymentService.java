package com.atguigu.springcloud.service;

import com.atguigu.springcloud.pojo.Payment;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Payment业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface PaymentService {

    /***
     * Payment多条件分页查询
     * @param payment
     * @param page
     * @param size
     * @return
     */
    PageInfo<Payment> findPage(Payment payment, int page, int size);

    /***
     * Payment分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Payment> findPage(int page, int size);

    /***
     * Payment多条件搜索方法
     * @param payment
     * @return
     */
    List<Payment> findList(Payment payment);

    /***
     * 删除Payment
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Payment数据
     * @param payment
     */
    void update(Payment payment);

    /***
     * 新增Payment
     * @param payment
     */
    void add(Payment payment);

    /**
     * 根据ID查询Payment
     * @param id
     * @return
     */
     Payment findById(Long id);

    /***
     * 查询所有Payment
     * @return
     */
    List<Payment> findAll();
}
