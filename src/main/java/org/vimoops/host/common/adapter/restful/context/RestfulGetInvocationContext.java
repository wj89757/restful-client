package org.vimoops.host.common.adapter.restful.context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.collections.MapUtils;

public class RestfulGetInvocationContext extends RestfulInvocationContext {
	public String getUrl() {
		if (MapUtils.isNotEmpty(this.getParams())) {
			List<String> keyValueList = convertGetUrlParamMap();

			if (super.getUrl()
			         .contains("?")) {
				return super.getUrl() + "&" + joinGetUrlParams(keyValueList);
			}
			return super.getUrl() + "?" + joinGetUrlParams(keyValueList);
		}
		return super.getUrl();
	}

	private List<String> convertGetUrlParamMap() {
		List<String> list = new ArrayList<String>();
		for (Entry<String, String> entry : this.getParams()
		                                       .entrySet()) {
			list.add(entry.getKey() + "=" + entry.getValue());
		}

		return list;
	}

	private String joinGetUrlParams(List<String> keyValueList) {
		StringBuilder sb = new StringBuilder(keyValueList.get(0));
		for (int i = 1; i < keyValueList.size(); ++i) {
			sb.append("&")
			  .append(keyValueList.get(i));
		}

		return sb.toString();
	}
}
