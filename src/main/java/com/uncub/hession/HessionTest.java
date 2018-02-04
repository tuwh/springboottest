/*
package com.uncub.hession;

import com.caucho.hessian.client.HessianProxyFactory;
import com.caucho.hessian.io.HessianFactory;
import com.uncub.controller.IUserController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.MalformedURLException;

@RequestMapping("/hessian")
public class HessionTest {
    @RequestMapping("/test")
    public void test() throws MalformedURLException {
        HessianProxyFactory hessianProxyFactory = new HessianProxyFactory();
        IUserController iUserController = (IUserController)hessianProxyFactory.create(IUserController.class,"http:localhost:8888");
        iUserController.getUserInfo("张三");
    }

}
*/
