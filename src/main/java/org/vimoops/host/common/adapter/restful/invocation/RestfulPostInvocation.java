package org.vimoops.host.common.adapter.restful.invocation;

import java.util.Map.Entry;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Form;

import org.apache.commons.collections.MapUtils;
import org.vimoops.host.common.adapter.restful.RestfulClient;
import org.vimoops.host.common.adapter.restful.context.RestfulInvocationContext;

public class RestfulPostInvocation<ResultType> extends
        RestfulInvocation<ResultType> {

	public RestfulPostInvocation(RestfulInvocationContext context,
	        RestfulClient<ResultType> restfulClient) {
		super(context, restfulClient);

	}

	@Override
	protected Invocation convertMethodToInvocation(Builder builder) {
		Form form = new Form();
		if (MapUtils.isNotEmpty(context.getParams())) {
			for (Entry<String, String> entry : context.getParams()
			                                          .entrySet()) {
				form.param(entry.getKey(), entry.getValue());
			}
		}

		return builder.buildPost(Entity.form(form));
	}

}
