package org.vimoops.host.common.adapter.restful;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.apache.commons.collections.MapUtils;

public abstract class AbstractRestfulReponseConvertor<ResultType> implements
        RestfulResponseConvertor<ResultType> {

	public RestfulResult<ResultType> convertResponse(Response response) {

		RestfulResult<ResultType> result = new RestfulResult<ResultType>();
		result.setCode(String.valueOf(response.getStatus()));
		
		this.dealHeaders(response, result);

		if (response.getStatus() == 200) {
			result.setSuccess(Boolean.TRUE);

			result.setData(convert(response));
		} else {
			result.setSuccess(Boolean.FALSE);
			result.setMessage(response.getStatusInfo()
			                          .toString());
		}

		return result;
	}
	
	private void dealHeaders(Response response, RestfulResult<ResultType> result){
	    Map<String, List<String>> headers = response.getStringHeaders();
	    if(MapUtils.isEmpty(headers)){
	        return;
	    }
	    
	    Map<String, List<String>> map = new HashMap<String, List<String>>();
	    
	    for(String header: headers.keySet()){
	        List<String> list = headers.get(header);
	        map.put(header, new ArrayList<String>(list));
	    }
	}

	public abstract ResultType convert(Response response);
	

}
