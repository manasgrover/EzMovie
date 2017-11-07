package com.easymovie.data.config;

/**
 * @author Manas Grover
 *
 */
public class PersistenceContext {

	private static final ThreadLocal<UserDetails> contextHolder = new InheritableThreadLocal<UserDetails>();

	public static UserDetails getContextholder() {
		return contextHolder.get();
	}

	public static void setContextHolder(UserDetails dcDetails) {
		contextHolder.set(dcDetails);
	}
}