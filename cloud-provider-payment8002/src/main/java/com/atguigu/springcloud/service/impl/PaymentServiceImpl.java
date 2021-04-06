package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentMapper;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Payment业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;


    /**
     * Payment条件+分页查询
     * @param payment 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Payment> findPage(Payment payment, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(payment);
        //执行搜索
        return new PageInfo<Payment>(paymentMapper.selectByExample(example));
    }

    /**
     * Payment分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Payment> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Payment>(paymentMapper.selectAll());
    }

    /**
     * Payment条件查询
     * @param payment
     * @return
     */
    @Override
    public List<Payment> findList(Payment payment){
        //构建查询条件
        Example example = createExample(payment);
        //根据构建的条件查询数据
        return paymentMapper.selectByExample(example);
    }


    /**
     * Payment构建查询对象
     * @param payment
     * @return
     */
    public Example createExample(Payment payment){
        Example example=new Example(Payment.class);
        Example.Criteria criteria = example.createCriteria();
        if(payment!=null){
            // 
            if(!StringUtils.isEmpty(payment.getId())){
                    criteria.andEqualTo("id",payment.getId());
            }
            // 
            if(!StringUtils.isEmpty(payment.getSerial())){
                    criteria.andEqualTo("serial",payment.getSerial());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id){
        paymentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Payment
     * @param payment
     */
    @Override
    public void update(Payment payment){
        paymentMapper.updateByPrimaryKey(payment);
    }

    /**
     * 增加Payment
     * @param payment
     */
    @Override
    public void add(Payment payment){
        paymentMapper.insert(payment);
    }

    /**
     * 根据ID查询Payment
     * @param id
     * @return
     */
    @Override
    public Payment findById(Long id){
        return  paymentMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Payment全部数据
     * @return
     */
    @Override
    public List<Payment> findAll() {
        return paymentMapper.selectAll();
    }
}
