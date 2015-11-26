package org.vimoops.host.common.adapter.restful;

public class StringResultRestfulClient extends RestfulClient<String> {
	public StringResultRestfulClient(){
		setRestfulResponseConvertor(new StringResultResponseConvertor());
	}
}
