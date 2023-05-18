package com.example.user.util;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * 流程ID生成器
 *
 * @author lvzb
 * @date 2022/08/18  19:06
 **/
@Slf4j
@Component
public class IdUtils {

    private static RedissonClient client;

    public IdUtils(RedissonClient client) {
        IdUtils.client = client;
    }



    /**
     * 服务前缀
     */
    public static final String SERVER_PREFIX = "DEM_";

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static Long nextId(){
       return nextId("");
    }

    public static Long nextId(String prefix) {
        prefix = prefix != null ? prefix : "FL";
        String key = SERVER_PREFIX.concat(prefix);
        // 通过redis的自增获取序号
        RAtomicLong atomicLong = client.getAtomicLong(key);
        long num = atomicLong.incrementAndGet();
        // num不够5位数时左补齐0
        return num;
    }
}
