package com.fangda.zookeeper;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.java.Log;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

@Log
public class SingleTest {


    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(2);
        ZooKeeper zooKeeper = new ZooKeeper("192.168.5.31:2181", 6000, watchedEvent -> {
            log.info("watchedEvent:" + watchedEvent);
            if (watchedEvent.getType() == Watcher.Event.EventType.NodeChildrenChanged) {
                log.info("NodeChildrenChanged:" + watchedEvent);
            }
        });

        Thread.sleep(5000);
        log.info("status:" + zooKeeper.getState());

        byte[] data = zooKeeper.getData("/fangda", false, new Stat());
        log.info("data:" + new String(data));

        zooKeeper.getChildren("/fangda", true, (i, s, o, list, stat) -> {
            log.info("list:" + JSONObject.toJSONString(list));
            log.info("stat:" + JSONObject.toJSONString(stat));
        }, "获取子节点列表成功");

        byte[] watch = zooKeeper.getData("/fangda/demo",
                watchedEvent -> {
                    log.info("watchedEvent:" + JSONObject.toJSONString(watchedEvent));
                }, new Stat());

        log.info("watch:" + new String(watch));

        zooKeeper.setData("/fangda/demo", "abac".getBytes(), 0, (i, s, o, stat) -> {
            log.info("o:" + JSONObject.toJSONString(o));
        }, "demo修改成功");

        log.info("finsh");

//        ZooDefs.Ids.ANYONE_ID_UNSAFE
    }
}
