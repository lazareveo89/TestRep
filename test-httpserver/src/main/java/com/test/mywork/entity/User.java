package com.test.mywork.entity;

public class User implements Comparable<User>{
	private Integer user_id;
	private Integer level_id;
	private Integer result;

	/**
	 * @return the level_id
	 */
	public Integer getLevel_id() {
		return level_id;
	}
	/**
	 * @param level_id the level_id to set
	 */
	public void setLevel_id(Integer level_id) {
		this.level_id = level_id;
	}
	/**
	 * @return the result
	 */
	public Integer getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(Integer result) {
		this.result = result;
	}
	public Integer getUser_id() {
		return user_id;
	}
	
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public int compareTo(User o) {
		return o.getResult() - this.result;
	}
		
	@Override
	public String toString() {
		return "{"+"user_id:"+this.user_id+","+"level_id:"+
					this.level_id+","+"result:"+this.result+"}";
	}
	
}
