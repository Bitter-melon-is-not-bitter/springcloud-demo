package com.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 自定义负载均衡
 * 每调用五次就换一个服务调用
 */
public class RandomRule_My extends AbstractLoadBalancerRule {
    //Random rand;
    //
    //public RandomRule_My() {
    //    rand = new Random();
    //}

    //定义一个total = 0 当total = 5后，我们指针才能往下走
    //定义一个index = 0 当前对外提供服务的服务器地址
    //total需要重新重置为0 当时已经达到过一个5次 ，我们的indeX = 1

    private int total = 0;          //总共被调用的次数，目前要求每台被调用5次
    private int currentIndex = 0;   //当前提供服务的机器号

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while (server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                //int index = this.rand.nextInt(serverCount);
                //server = (Server) upList.get(index);

                if (total < 5) {
                    server = upList.get(currentIndex);
                    total++;
                } else {
                    total = 0;
                    currentIndex++;
                    if (currentIndex >= upList.size()) {
                        currentIndex = 0;
                    }
                }


                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
