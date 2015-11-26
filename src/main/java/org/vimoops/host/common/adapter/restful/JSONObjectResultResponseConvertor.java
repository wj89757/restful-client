package org.vimoops.host.common.adapter.restful;

import javax.ws.rs.core.Response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JSONObjectResultResponseConvertor extends
AbstractRestfulReponseConvertor<JSONObject> {

    @Override
    public JSONObject convert(Response response) {
        String stringResult = response.readEntity(String.class);
        
        return JSON.parseObject(stringResult);
    }
    
    

}
