package org.vimoops.host.common.adapter.restful.invocation;

import org.vimoops.host.common.adapter.restful.context.RestfulInvocationContext;


public interface RestfulInvocationPrepare {
	void prepareInvocation(RestfulInvocationContext context);
}
