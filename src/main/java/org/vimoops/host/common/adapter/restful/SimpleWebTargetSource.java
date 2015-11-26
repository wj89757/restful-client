package org.vimoops.host.common.adapter.restful;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class SimpleWebTargetSource implements WebTargetSource {

	private Client	client;

	public WebTarget getWebTarget(String url) {
		return client.target(url);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
