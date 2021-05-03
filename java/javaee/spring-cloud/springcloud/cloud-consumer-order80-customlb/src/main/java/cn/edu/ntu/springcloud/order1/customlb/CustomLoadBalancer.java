package cn.edu.ntu.springcloud.order1.customlb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zack <br>
 * @create 2020-04-01 21:44 <br>
 */
@Component
public class CustomLoadBalancer implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {

        int index = getAndIncrease() % instances.size();

        return instances.get(index);
    }

    /**
     * about AtomicInteger: <br>
     * if (this == expect) { this = update return true; } else { return false; }
     *
     * @apiNote next it the request times
     * @return
     */
    private final int getAndIncrease() {

        int current, next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));

        return next;
    }
}
