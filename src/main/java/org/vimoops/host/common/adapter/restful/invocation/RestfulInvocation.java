package org.vimoops.host.common.adapter.restful.invocation;

import java.util.Map.Entry;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.vimoops.host.common.adapter.restful.RestfulClient;
import org.vimoops.host.common.adapter.restful.RestfulResponseConvertor;
import org.vimoops.host.common.adapter.restful.RestfulResult;
import org.vimoops.host.common.adapter.restful.context.RestfulInvocationContext;

public abstract class RestfulInvocation<ResultType> {

	protected RestfulInvocationContext	           context;

	protected RestfulClient<ResultType>	           restfulClient;

	protected RestfulResponseConvertor<ResultType>	restfulResponseConvertor;

	public RestfulInvocation(RestfulInvocationContext context,
	        RestfulClient<ResultType> restfulClient) {
		this.context = context;
		this.restfulClient = restfulClient;

	}

	public RestfulResult<ResultType> invoke() {

		WebTarget target = restfulClient.getWebTargetSource()
		                                .getWebTarget(context.getUrl());

		Invocation.Builder builder = target.request();

		doGeneralInvocationInit(builder);

		Invocation invocation = convertMethodToInvocation(builder);

		Response response = invocation.invoke();

		RestfulResult<ResultType> result = restfulResponseConvertor.convertResponse(response);

		return result;
	}

	protected abstract Invocation convertMethodToInvocation(
	        Invocation.Builder builder);

	private void doGeneralInvocationInit(Invocation.Builder builder) {
		if (CollectionUtils.isNotEmpty(context.getMediaTypes())) {
			builder.accept(context.getMediaTypes()
			                      .toArray(new String[0]));
		}
		if (MapUtils.isNotEmpty(context.getHeaders())) {
			for (Entry<String, String> entry : context.getHeaders()
			                                          .entrySet()) {
				builder.header(entry.getKey(), entry.getValue());
			}
		}
		if (MapUtils.isNotEmpty(context.getCookies())) {
			for (Entry<String, String> entry : context.getCookies()
			                                          .entrySet()) {
				builder.cookie(entry.getKey(), entry.getValue());
			}
		}
	}

	public void setRestfulInvocationContext(RestfulInvocationContext context) {
		this.context = context;
	}

	public RestfulInvocationContext getContext() {
		return context;
	}

	public void setContext(RestfulInvocationContext context) {
		this.context = context;
	}

	public RestfulClient<ResultType> getRestfulClient() {
		return restfulClient;
	}

	public void setRestfulClient(RestfulClient<ResultType> restfulClient) {
		this.restfulClient = restfulClient;
	}

	public RestfulResponseConvertor<ResultType> getRestfulResponseConvertor() {
		return restfulResponseConvertor;
	}

	public void setRestfulResponseConvertor(
	        RestfulResponseConvertor<ResultType> restfulResponseConvertor) {
		this.restfulResponseConvertor = restfulResponseConvertor;
	}

}
