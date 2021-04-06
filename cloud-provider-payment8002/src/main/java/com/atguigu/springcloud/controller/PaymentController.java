package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.pojo.Result;
import com.atguigu.springcloud.pojo.StatusCode;
import com.atguigu.springcloud.service.PaymentService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "PaymentController")
@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /***
     * Payment分页条件搜索实现
     * @param payment
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Payment条件分页查询",notes = "分页条件查询Payment方法详情",tags = {"PaymentController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Payment对象",value = "传入JSON数据",required = false) Payment payment, @PathVariable  int page, @PathVariable  int size){
        //调用PaymentService实现分页条件查询Payment
        PageInfo<Payment> pageInfo = paymentService.findPage(payment, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Payment分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Payment分页查询",notes = "分页查询Payment方法详情",tags = {"PaymentController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PaymentService实现分页查询Payment
        PageInfo<Payment> pageInfo = paymentService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param payment
     * @return
     */
    @ApiOperation(value = "Payment条件查询",notes = "条件查询Payment方法详情",tags = {"PaymentController"})
    @PostMapping(value = "/search" )
    public Result<List<Payment>> findList(@RequestBody(required = false) @ApiParam(name = "Payment对象",value = "传入JSON数据",required = false) Payment payment){
        //调用PaymentService实现条件查询Payment
        List<Payment> list = paymentService.findList(payment);
        return new Result<List<Payment>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Payment根据ID删除",notes = "根据ID删除Payment方法详情",tags = {"PaymentController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用PaymentService实现根据主键删除
        paymentService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Payment数据
     * @param payment
     * @param id
     * @return
     */
    @ApiOperation(value = "Payment根据ID修改",notes = "根据ID修改Payment方法详情",tags = {"PaymentController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Payment对象",value = "传入JSON数据",required = false) Payment payment,@PathVariable Long id){
        //设置主键值
        payment.setId(id);
        //调用PaymentService实现修改Payment
        paymentService.update(payment);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Payment数据
     * @param payment
     * @return
     */
    @ApiOperation(value = "Payment添加",notes = "添加Payment方法详情",tags = {"PaymentController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Payment对象",value = "传入JSON数据",required = true) Payment payment){
        //调用PaymentService实现添加Payment
        paymentService.add(payment);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Payment数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Payment根据ID查询",notes = "根据ID查询Payment方法详情",tags = {"PaymentController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<Payment> findById(@PathVariable Long id){
        //调用PaymentService实现根据主键查询Payment
        Payment payment = paymentService.findById(id);
        return new Result<Payment>(true,StatusCode.OK,"查询成功8002",payment);
    }

    /***
     * 查询Payment全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Payment",notes = "查询所Payment有方法详情",tags = {"PaymentController"})
    @GetMapping
    public Result<List<Payment>> findAll(){
        //调用PaymentService实现查询所有Payment
        List<Payment> list = paymentService.findAll();
        return new Result<List<Payment>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
