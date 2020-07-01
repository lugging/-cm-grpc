package cm.yuntongxun.grpc.server.service;

import cm.yuntongxun.grpc.service.user.QueryUser;
import cm.yuntongxun.grpc.service.user.UserServiceGrpc;
import cn.hutool.core.util.RandomUtil;
import com.google.api.client.util.Lists;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

/**
 * @program: cm-grpc
 * @description:
 * @author: liugang
 * @create: 2020-06-17 22:20
 **/
@Slf4j
@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void queryUser(QueryUser.queryUserReq request, StreamObserver<QueryUser.QueryUserReply> responseObserver) {
        log.info(" UserService#queryUser {} ", request.getName());
        List<QueryUser.UserInfo> userInfoList = Lists.newArrayList();
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        userInfoList.add( QueryUser.UserInfo.newBuilder().setAge(RandomUtil.randomInt()).setMessage(RandomUtil.randomString(5)).build());
        QueryUser.QueryUserReply reply =  QueryUser.QueryUserReply.newBuilder().addAllUserInfo(userInfoList).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
