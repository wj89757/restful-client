package org.vimoops.host.common.adapter.restful;

import org.vimoops.host.common.adapter.restful.context.RestfulInvocationContext;

public interface RestfulInvocationIntercepter {
    void beforeInvoke(RestfulInvocationContext context);
}
