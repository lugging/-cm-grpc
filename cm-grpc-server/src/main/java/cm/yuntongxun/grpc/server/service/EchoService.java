package cm.yuntongxun.grpc.server.service;

import cm.yuntongxun.grpc.service.echo.EchoGrpc;
import cm.yuntongxun.grpc.service.echo.EchoProto;
import cn.hutool.core.date.DateUtil;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @program: cm-grpc
 * @description:
 * @author: liugang
 * @create: 2020-06-12 15:51
 **/
@Slf4j
@GrpcService
public class EchoService extends EchoGrpc.EchoImplBase {

    @Override
    public void sayHello(EchoProto.HelloRequest request, StreamObserver<EchoProto.HelloReply> responseObserver) {
        log.info(" EchoService#sayHello {} ", request.getName());
        EchoProto.HelloReply reply = EchoProto.HelloReply.newBuilder().setMessage(DateUtil.now()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
