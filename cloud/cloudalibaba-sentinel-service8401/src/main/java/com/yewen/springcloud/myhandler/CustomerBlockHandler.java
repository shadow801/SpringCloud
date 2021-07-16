package com.yewen.springcloud.myhandler;


import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yewen.springcloud.entities.CommonResult;

/**
 * @author ShadowStart
 * @create 2021-07-12 21:49
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException blockException) {
        return new CommonResult(4444, "按客户自定义，global handlerException---1");
    }
    public static CommonResult handlerException2(BlockException blockException) {
        return new CommonResult(4444, "按客户自定义，global handlerException---2");
    }
}
