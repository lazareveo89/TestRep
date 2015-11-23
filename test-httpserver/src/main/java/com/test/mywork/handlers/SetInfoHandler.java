package com.test.mywork.handlers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.hazelcast.core.IMap;
import com.hazelcast.core.IdGenerator;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.test.mywork.entity.User;
import com.test.mywork.helpers.UtilHelper;

public class SetInfoHandler implements HttpHandler {
	
	private static final Logger LOG = Logger.getLogger(SetInfoHandler.class);
	private static IMap< Long, String> mapCustomers = UtilHelper.getINSTANCE().getMap("users");
	private static IdGenerator gen = UtilHelper.getINSTANCE().getIdGenerator("gen");
	public void handle(HttpExchange httpExchange) {

		StringBuilder response = new StringBuilder();
		Map<String, String> params = queryToMap(httpExchange.getRequestURI()
				.getQuery());
		User user = new User();
		user.setUser_id(Integer.parseInt(params.get("userId")));
		user.setLevel_id(Integer.parseInt(params.get("levelId")));
		user.setResult(Integer.parseInt(params.get("result")));
		mapCustomers.put(gen.newId(), user.toString());
		response.append("<html><body>");
		response.append("</body></html>");
		try {
			httpExchange.sendResponseHeaders(200, response.length());
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	private Map<String, String> queryToMap(String query) {

		Map<String, String> result = new HashMap<String, String>();
		for (String param : query.split("&")) {
			String pair[] = param.split("=");
			if (pair.length > 1) {
				result.put(pair[0], pair[1]);
			} else {
				result.put(pair[0], "");
			}
		}
		return result;
	}
}