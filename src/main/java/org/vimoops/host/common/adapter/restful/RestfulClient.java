package org.vimoops.host.common.adapter.restful;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.vimoops.host.common.adapter.restful.context.RestfulGetInvocationContext;
import org.vimoops.host.common.adapter.restful.context.RestfulInvocationContext;
import org.vimoops.host.common.adapter.restful.invocation.RestfulGetInvocation;
import org.vimoops.host.common.adapter.restful.invocation.RestfulInvocation;
import org.vimoops.host.common.adapter.restful.invocation.RestfulInvocationPrepare;
import org.vimoops.host.common.adapter.restful.invocation.RestfulPostInvocation;

public class RestfulClient<ResultType> {

    private WebTargetSource                      webTargetSource;

    private RestfulResponseConvertor<ResultType> restfulResponseConvertor;

    private List<RestfulInvocationIntercepter>   interceptors;

    public RestfulResult<ResultType> doPost(RestfulInvocationPrepare prepare) {

        RestfulInvocationContext context = new RestfulInvocationContext();
        prepare.prepareInvocation(context);

        RestfulPostInvocation<ResultType> invocation = new RestfulPostInvocation<ResultType>(
                context, this);

        invocation.setRestfulResponseConvertor(restfulResponseConvertor);

        return this.doInvoke(invocation);
    }

    public RestfulResult<ResultType> doGet(RestfulInvocationPrepare prepare) {

        RestfulInvocationContext context = new RestfulGetInvocationContext();
        prepare.prepareInvocation(context);

        RestfulGetInvocation<ResultType> invocation = new RestfulGetInvocation<ResultType>(
                context, this);

        invocation.setRestfulResponseConvertor(restfulResponseConvertor);

        return this.doInvoke(invocation);
    }

    public RestfulResult<ResultType> doPut(RestfulInvocationPrepare prepare) {
        return null;
    }

    public RestfulResult<ResultType> doDelete(RestfulInvocationPrepare prepare) {
        return null;
    }

    public RestfulResult<ResultType> doInvoke(
            RestfulInvocation<ResultType> invocation) {
        if (CollectionUtils.isNotEmpty(interceptors)) {
            for (RestfulInvocationIntercepter intercepter : interceptors) {
                intercepter.beforeInvoke(invocation.getContext());
            }
        }

        return invocation.invoke();
    }

    public WebTargetSource getWebTargetSource() {
        return webTargetSource;
    }

    public RestfulResponseConvertor<ResultType> getRestfulResponseConvertor() {
        return restfulResponseConvertor;
    }

    public void setRestfulResponseConvertor(
            RestfulResponseConvertor<ResultType> restfulResponseConvertor) {
        this.restfulResponseConvertor = restfulResponseConvertor;
    }

    public void setWebTargetSource(WebTargetSource webTargetSource) {
        this.webTargetSource = webTargetSource;
    }

    public List<RestfulInvocationIntercepter> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<RestfulInvocationIntercepter> interceptors) {
        this.interceptors = interceptors;
    }

}
