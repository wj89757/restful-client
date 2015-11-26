package org.vimoops.host.common.adapter.restful.invocation;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;

import org.vimoops.host.common.adapter.restful.RestfulClient;
import org.vimoops.host.common.adapter.restful.context.RestfulInvocationContext;

public class RestfulGetInvocation<ResultType> extends
        RestfulInvocation<ResultType> {
	
	public RestfulGetInvocation(RestfulInvocationContext context,
	        RestfulClient<ResultType> restfulClient) {
		super(context, restfulClient);

	}

	@Override
	protected Invocation convertMethodToInvocation(Builder builder) {
		return builder.buildGet();
	}

}
