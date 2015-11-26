package org.vimoops.host.common.adapter.restful;

import javax.ws.rs.core.Response;

public class StringResultResponseConvertor extends
        AbstractRestfulReponseConvertor<String> {

	@Override
    public String convert(Response response) {
	    return response.readEntity(String.class);
    }

}
