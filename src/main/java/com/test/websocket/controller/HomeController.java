package com.test.websocket.controller;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.websocket.entity.TestBean;
import com.test.websocket.repository.TestDao;

@Controller
public class HomeController {
    @Autowired
    private MyWebSocketHandler myWebSocketHandler;
    @Autowired
    private TestDao dao;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/getTest")
	public @ResponseBody TestBean postTest() throws IOException {
        TestBean bean = new TestBean(new Date());
        dao.save(bean);
        myWebSocketHandler.sendMessage(bean);
		return bean;
	}
}
