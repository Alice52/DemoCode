package boot.webflux.client.component.interfaces;

import boot.webflux.client.common.beans.MethodInfo;
import boot.webflux.client.common.beans.ServerInfo;

/**
 * @author zack <br>
 * @create 2021-04-11 17:25 <br>
 * @project springboot <br>
 */
public interface IRestHandler {

    Object invokeRest(MethodInfo methodInfo);

    void initServerInfo(ServerInfo info);
}
