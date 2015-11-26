package org.vimoops.host.common.adapter.restful;

import javax.ws.rs.client.WebTarget;

public interface WebTargetSource {
	WebTarget getWebTarget(String url);
}
