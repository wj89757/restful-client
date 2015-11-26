package org.vimoops.host.common.adapter.restful.context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestfulInvocationContext {
	private String	            method;

	private String	            url;

	private Map<String, String>	params;

	private Map<String, String>	headers;

	private Map<String, String>	cookies;

	private List<String>	    mediaTypes;

	public RestfulInvocationContext method(String theMethod) {
		this.method = theMethod;

		return this;
	}

	public RestfulInvocationContext param(String name, String value) {
		if (this.params == null) {
			this.params = new HashMap<String, String>();
		}
		this.params.put(name, value);

		return this;
	}

	public RestfulInvocationContext url(String theUrl) {
		this.url = theUrl;

		return this;
	}

	public RestfulInvocationContext header(String name, String value) {
		if (this.headers == null) {
			this.headers = new HashMap<String, String>();
		}
		this.headers.put(name, value);

		return this;
	}

	public RestfulInvocationContext cookie(String name, String value) {
		if (this.cookies == null) {
			this.cookies = new HashMap<String, String>();
		}
		this.cookies.put(name, value);

		return this;
	}

	public RestfulInvocationContext accept(String... theMediaTypes) {
		if (this.mediaTypes == null) {
			this.mediaTypes = new ArrayList<String>();
		}
		this.mediaTypes.addAll(Arrays.asList(theMediaTypes));

		return this;
	}

	public String getMethod() {
		return method;
	}

	public String getUrl() {
		return url;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, String> getCookies() {
		return cookies;
	}

	public List<String> getMediaTypes() {
		return mediaTypes;
	}

}
