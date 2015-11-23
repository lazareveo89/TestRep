package com.test.mywork.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IdGenerator;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.test.mywork.entity.User;
import com.test.mywork.helpers.UtilHelper;

public class LevelInfoHandler implements HttpHandler{

	private static final Logger LOG = Logger.getLogger(LevelInfoHandler.class);
	private static IMap< Long, String> mapCustomers = UtilHelper.getINSTANCE().getMap("users");
	private static IdGenerator gen = UtilHelper.getINSTANCE().getIdGenerator("gen");
	public void handle(HttpExchange httpExchange) throws IOException {
		//test set data
				/*for(int i = 0; i < 25; i++){
					User u = new User();
					u.setUser_id(3+i);
					u.setLevel_id(1);
					u.setResult(1+i);
					UtilHelper.getMapCustomers().put(UtilHelper.getGen().newId(), u.toString());
				}*/
				////////////////////
				
				String reqUri = httpExchange.getRequestURI().getPath();
				String level_id = reqUri.substring(11, reqUri.length()); // /levelinfo/1 --> 1
				Gson gson = new Gson();
				List<User> listUsers = new ArrayList<User>();
				List<Integer> userIdList = new ArrayList<Integer>();
				Integer levelId = Integer.parseInt(level_id);
				for(Entry<Long, String> entry : mapCustomers.entrySet()){
					User userFromMap = gson.fromJson(entry.getValue(), User.class);
					if(userFromMap.getLevel_id().compareTo(levelId) == 0){
						listUsers.add(userFromMap);
					}
				}
				if(!userIdList.contains(levelId)){
					User u = new User();
					u.setLevel_id(levelId);
					mapCustomers.put(gen.newId(), u.toString());
				}
				
				Collections.sort(listUsers);
				
				StringBuilder response = new StringBuilder();
				response.append("<html><body>");
			
				if(listUsers.size() > 20){
					for(int i=0; i < 20; i++) {
						response.append("user_id:");
						response.append(listUsers.get(i).getUser_id());
						response.append(",");
						response.append("result:");
						response.append(listUsers.get(i).getResult());
						response.append("<br/>");
					}
				} else {
					for(User user : listUsers) {
						response.append("user_id:");
						response.append(user.getUser_id());
						response.append(",");
						response.append("result:");
						response.append(user.getResult());
						response.append("<br/>");
					}
				}
					response.append("</body></html>");
				try {
					writeResponse(httpExchange, response.toString());
				} catch(IOException e) {
					try {
						httpExchange.sendResponseHeaders(500, response.length());
					} catch (IOException e1) {
						LOG.error(e.getMessage(), e1);
					} finally {
						LOG.error(e.getMessage(), e);
					}
				}
		}
	private void writeResponse(HttpExchange httpExchange, String response) throws IOException {
	    httpExchange.sendResponseHeaders(200, response.length());
	    OutputStream os = httpExchange.getResponseBody();
	    os.write(response.getBytes());
	    os.close();
	  }

}