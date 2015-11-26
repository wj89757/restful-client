package org.vimoops.host.common.adapter.restful;

import javax.ws.rs.core.Response;

public interface RestfulResponseConvertor<ResultType> {
	RestfulResult<ResultType> convertResponse(Response response);
}
