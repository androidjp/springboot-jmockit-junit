package com.example.demo.controller;

import com.example.demo.bean.Computer;
import com.example.demo.dto.JsonRes;
import com.example.demo.service.DiyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * User: androidjp
 * Date: 2018/5/12
 * Time: 下午4:41
 * Description:
 */
@RestController
@RequestMapping("/diy")
public class DiyControllerImpl implements DiyPcController {

    @Resource(name = "diyServiceImpl")
    private DiyService diyService;

    @GetMapping("/buy")
    @Override
    public JsonRes buyDiyPc(@RequestParam("id") String userId, @RequestParam("money") double money, @RequestParam("usage") String usage) throws Exception {
        Computer computer = diyService.buildCompatibleComputer(money, usage);
        if (computer == null) {
            return new JsonRes(200, "没有符合你要求的Diy主机哦，再另外选择价格吧", null);
        }
        return new JsonRes(200, "success", computer);
    }

    public JsonRes run() {
        return new JsonRes(200, "success", null);
    }
}
