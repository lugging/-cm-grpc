package cm.yuntongxun.grpc.client.service;

import cm.yuntongxun.grpc.service.echo.EchoGrpc;
import cm.yuntongxun.grpc.service.echo.EchoProto;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @program: cm-grpc
 * @description:
 * @author: liugang
 * @create: 2020-06-12 15:59
 **/
@Slf4j
@Service
public class EchoService {

    @GrpcClient("userService")
    private EchoGrpc.EchoBlockingStub echoBlockingStub;

    public String receiveGreeting(String name) {
        log.info("EchoService#receiveGreeting {}", name);
        EchoProto.HelloRequest request = EchoProto.HelloRequest.newBuilder().setName(name).build();
        return echoBlockingStub.sayHello(request).getMessage();
    }

    public String maxSize(int size) {
        log.info("EchoService#maxSize {}", size);
        EchoProto.HelloRequest request = EchoProto.HelloRequest
                .newBuilder()
                .setName(RandomUtil.randomString(size))
                .build();
        return echoBlockingStub.sayHello(request).getMessage();
    }
}
