package com.example.user;

import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserApplicationTests {
    private static final String LARGE_KEY_PREFIX = "large_key:";
    private static final Integer PARTITION_SIZE = 3;

    /**
     * 大key拆分
     */
    @Test
    void contextLoads() {
        // 连接到Redis集群
        Config config = new Config();
        config.useClusterServers()
                .addNodeAddress("redis://192.168.3.60:6379", "redis://192.168.3.60:6380", "redis://192.168.3.60:6381");

        RedissonClient redisson = Redisson.create(config);

        // 将大Key分区存储
        String largeKey = "ls_large_key";
        String largeValue = "ls_large_value_value";
        saveLargeKey(redisson, largeKey, largeValue);

        // 从Redis中获取大Key
        String retrievedValue = retrieveLargeKey(redisson, largeKey);
        System.out.println("Retrieved large value: " + retrievedValue);

        redisson.shutdown(); // 关闭Redisson连接
    }

    private static void saveLargeKey(RedissonClient redisson, String key, String value) {
        int length = value.length();
        int partitions = (length + PARTITION_SIZE - 1) / PARTITION_SIZE;
        for (int i = 0; i < partitions; i++) {
            int beginIndex = i * PARTITION_SIZE;
            int endIndex = Math.min(beginIndex + PARTITION_SIZE, length);
            String partitionKey = LARGE_KEY_PREFIX + key + ":" + i;
            System.out.println("partitionKey ==" + partitionKey);
            String partitionValue = value.substring(beginIndex, endIndex);
            RBucket<String> bucket = redisson.getBucket(partitionKey);
            bucket.set(partitionValue);
        }
    }

    private static String retrieveLargeKey(RedissonClient redisson, String key) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (true) {
            String partitionKey = LARGE_KEY_PREFIX + key + ":" + index;
            RBucket<String> bucket = redisson.getBucket(partitionKey);
            String partitionValue = bucket.get();
            if (partitionValue == null) {
                break;
            }
            sb.append(partitionValue);
            index++;
        }
        return sb.toString();
    }

}
