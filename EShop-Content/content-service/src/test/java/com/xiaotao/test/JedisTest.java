package com.xiaotao.test;

import com.xiaotao.common.jedis.JedisClient;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.*;

import java.util.HashSet;

/**
 * Created by 13725 on 2018/4/10.
 */
public class JedisTest {

    @Test
    public void testRedis() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        JedisPool pool = new JedisPool(config,"192.168.25.80", 6379,1000,"123456");
        Jedis jedis = pool.getResource();
        jedis.auth("123456");
        jedis.set("one", "hello jedis");
        String value = jedis.get("one");
        System.out.println(value);
        jedis.close();
        pool.close();
    }

    @Test
    public void testRedis2() {
        HashSet<HostAndPort> hostAndPorts = new HashSet<>();
        hostAndPorts.add(new HostAndPort("192.168.25.80", 6379));
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        JedisCluster cluster = new JedisCluster(hostAndPorts,10000,10000,3,"123456",config);
        cluster.auth("123456");
        cluster.set("two", "hello jedis two");
        String value = cluster.get("two");
        System.out.println(value);
    }

    @Test
    public void testRedis3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-jedis.xml");
        JedisClient jedisClient = context.getBean(JedisClient.class);
        String one = jedisClient.get("one");
        System.out.println(one);
    }
}
