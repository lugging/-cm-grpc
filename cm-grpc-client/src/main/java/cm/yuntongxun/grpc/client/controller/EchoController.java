package cm.yuntongxun.grpc.client.controller;

import cm.yuntongxun.grpc.client.service.EchoService;
import cm.yuntongxun.grpc.client.service.UserService;
import cm.yuntongxun.grpc.service.user.QueryUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: cm-grpc
 * @description:
 * @author: liugang
 * @create: 2020-06-12 16:01
 **/
@Slf4j
@RequestMapping(value = "echo")
@RestController
public class EchoController {

    @Autowired
    private EchoService echoService;

    @Autowired
    private UserService userService;

    @GetMapping("say")
    public ResponseEntity<String> say(@RequestParam("name") String name){
        String msg = echoService.receiveGreeting(name);
        return ResponseEntity.ok(msg);
    }

    @GetMapping("max")
    public ResponseEntity<String> say(@RequestParam("size") int size){
        String msg = echoService.maxSize(size);
        return ResponseEntity.ok(msg);
    }

    @GetMapping("user")
    public ResponseEntity<List<QueryUser.UserInfo>> user(@RequestParam("name") String name){
        List<QueryUser.UserInfo> userInfos = userService.receiveGreeting(name);
        return ResponseEntity.ok(userInfos);
    }
}
