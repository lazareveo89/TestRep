package com.test.mywork.httpsrv;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;

import com.sun.net.httpserver.HttpServer;
import com.test.mywork.handlers.LevelInfoHandler;
import com.test.mywork.handlers.SetInfoHandler;
import com.test.mywork.handlers.UserInfoHandler;
import com.test.mywork.helpers.UtilHelper;

public class HttpSrv {
	private static final Logger LOG = Logger.getLogger(HttpSrv.class);
	//http://127.0.0.1:8000/
	public static void main(String[] args) {
		new UtilHelper();
		try{
			HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
			server.createContext("/userinfo", new UserInfoHandler());
			server.createContext("/levelinfo", new LevelInfoHandler());
			server.createContext("/setinfo", new SetInfoHandler());
			server.setExecutor(null);
			server.start();
		} catch(Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}
}