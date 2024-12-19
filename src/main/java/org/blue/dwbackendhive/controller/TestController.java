package org.blue.dwbackendhive.controller;


import org.blue.dwbackendhive.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Neo0214
 */
@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @GetMapping("/test")
    public String test() {
        return testMapper.test();
    }
}
