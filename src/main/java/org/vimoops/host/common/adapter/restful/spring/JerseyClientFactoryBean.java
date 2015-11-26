package org.vimoops.host.common.adapter.restful.spring;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.springframework.beans.factory.FactoryBean;

public class JerseyClientFactoryBean implements FactoryBean<Client> {

	public Client getObject() throws Exception {
	    return ClientBuilder.newClient();
    }

	public Class<?> getObjectType() {
	    return Client.class;
    }

	public boolean isSingleton() {
	    return true;
    }

}
