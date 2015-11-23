package com.test.mywork.helpers;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class UtilHelper {
	private static HazelcastInstance INSTANCE = Hazelcast.newHazelcastInstance(new Config());;
	
	public static HazelcastInstance getINSTANCE() {
		return INSTANCE;
	}
}