package boot.webflux.client.component;

import boot.webflux.client.api.EmployeeApi;
import boot.webflux.client.component.interfaces.IProxyCreator;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2021-04-11 16:34 <br>
 * @project springboot <br>
 */
@Component
public class EmployeeFactoryBean implements FactoryBean<EmployeeApi> {

    @Resource IProxyCreator<EmployeeApi> proxyCreator;

    @Override
    public EmployeeApi getObject() throws Exception {
        return proxyCreator.createProxy(getObjectType());
    }

    @Override
    public Class<?> getObjectType() {
        return EmployeeApi.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
