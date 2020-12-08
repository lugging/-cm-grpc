package cm.yuntongxun.grpc.client.service;

import cm.yuntongxun.grpc.service.user.QueryUser;
import cm.yuntongxun.grpc.service.user.UserServiceGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: cm-grpc
 * @description:
 * @author: liugang
 * @create: 2020-06-17 22:28
 **/
@Slf4j
@Service
public class UserService {

    @GrpcClient("userService")
    private UserServiceGrpc.UserServiceBlockingStub stub1;

    public List<QueryUser.UserInfo> receiveGreeting(String name) {
        log.info("EchoService#receiveGreeting {}", name);
        QueryUser.queryUserReq req = QueryUser.queryUserReq.newBuilder().setName(name).build();
        QueryUser.QueryUserReply reply1 = stub1.queryUser(req);
        log.info("reply1 {}", reply1);
        return reply1.getUserInfoList();
    }
}
