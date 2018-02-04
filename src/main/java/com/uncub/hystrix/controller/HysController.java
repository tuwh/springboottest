package com.uncub.hystrix.controller;

import com.netflix.hystrix.*;
import com.uncub.hystrix.service.HysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/hys")
public class HysController {
    HysService hysService = new HysService("hysService");

    @RequestMapping("/test")
    public String test() throws ExecutionException, InterruptedException {
        HysService hysService = new HysService("hysService");
        Future<String> future = hysService.queue();
        String res = future.get();
        System.out.println(res);
        return res;
    }


}
