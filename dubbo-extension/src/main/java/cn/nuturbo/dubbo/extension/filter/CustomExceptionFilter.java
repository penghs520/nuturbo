package cn.nuturbo.dubbo.extension.filter;

import cn.nuturbo.common.vo.Result;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.rpc.*;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * Created by penghs at 2024/2/15 10:06
 */
public class CustomExceptionFilter implements Filter, Filter.Listener {

   private static final Logger logger = LoggerFactory.getLogger(CustomExceptionFilter.class);

    @Override
    public org.apache.dubbo.rpc.Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        return invoker.invoke(invocation);

    }

    @Override
    public void onResponse(org.apache.dubbo.rpc.Result result, Invoker<?> invoker, Invocation invocation) {
        if (result instanceof AppResponse appResponse) {
            if (appResponse.hasException() && GenericService.class != invoker.getInterface()) {
                appResponse.setValue(Result.error(appResponse.getException().getMessage()));
                appResponse.setException(null);
            }
        }
    }

    @Override
    public void onError(Throwable t, Invoker<?> invoker, Invocation invocation) {
        logger.error("CustomExceptionFilter error", t);
    }
}
