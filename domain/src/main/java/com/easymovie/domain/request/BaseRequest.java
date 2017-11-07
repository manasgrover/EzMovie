/**
 * 
 */
package com.easymovie.domain.request;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manas Grover
 *
 */
public class BaseRequest{

	private Map<HeaderKey,String> headers;
	private Map<Cookiekey,String> cookies;

	public Map<HeaderKey, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<HeaderKey, String> headers) {
		if(headers != null){
			this.headers = headers;
		}
	}

	public Map<Cookiekey, String> getCookies() {
		return cookies;
	}

	public void setCookies(Map<Cookiekey, String> cookies) {
		if(cookies != null){
			this.cookies = cookies;
		}
	}

	public enum HeaderKey{

		username("username"),
		password("password"),
		tenant_password("tenant_password"),
		remote_ip_address("remote_ip_address"),
		userAgent("user-agent");

		private String key;

		HeaderKey(String key){
			this.key = key;
		}

		public String getKey() {
			return key;
		}

		public static HeaderKey contains(String value){
			try {
				return HeaderKey.valueOf(value);
			} catch (Exception e) {
				return null;
			}
		}
	}

	public enum Cookiekey{
		device_fingerprint_id("deviceFingerprintId");

		private String key;

		Cookiekey(String key){
			this.key = key;
		}

		public String getKey() {
			return key;
		}

		public static Cookiekey contains(String value){
			try {
				for(Cookiekey ck : Cookiekey.values()){
					if(ck.getKey() == value){
						return ck;
					}
				}
				return null;
			} catch (Exception e) {
				return null;
			}
		}
	}

	
	public BaseRequest(){
		super();
		this.cookies = new HashMap<Cookiekey,String>();
		this.headers = new HashMap<HeaderKey,String>();		
	}
}
