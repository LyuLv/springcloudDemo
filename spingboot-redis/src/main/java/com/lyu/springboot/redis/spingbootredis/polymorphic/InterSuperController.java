package com.lyu.springboot.redis.spingbootredis.polymorphic;

import com.lyu.springboot.redis.spingbootredis.msg.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 10:10 2020/10/12
 * @Modified By:
 */
@RestController
@RequestMapping(name = "测试多实现", value = {"/inter"})
public class InterSuperController {

    @GetMapping(name = "测试接口多实现", value = {"/sup/{id}"})
    public BaseResponse inter(@PathVariable("id") String id) {
        Map<String, InterSuper> superMap = AppContent.getBeansOfType(InterSuper.class);
        superMap.forEach((s, interSuper) -> {
            interSuper.dispatch(id);
        });
//        InterSuper interSuper = AppContent.getBean(InterSuper.class);
//        interSuper.dispatch(id);
        System.out.println("执行完成");
        BaseResponse response = new BaseResponse();
        response.setMessage("测试成功");
        return response;
    }

}
