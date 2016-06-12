package esbtest.test;

import java.io.Serializable;
import java.util.Date;

public class RegisterMsgDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String appName;
	private String[] keyPatterns;
	private String ip;
	private String[] changeHandlerKeys;
	private Date startupTime;

	public RegisterMsgDto() {}

	public RegisterMsgDto(String appName, String[] keyPatterns, String ip, String[] handlerKeys, Date startupTime) {
	    this.appName = appName;
	    this.keyPatterns = keyPatterns;
	    this.changeHandlerKeys = handlerKeys;
	    this.ip = ip;
	    this.startupTime = startupTime;
	}
	
	public String getAppName() {
		return this.appName;
	}
	
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	public String[] getKeyPatterns() {
		return this.keyPatterns;
	}
	public void setKeyPatterns(String[] keyPatterns) {
		this.keyPatterns = keyPatterns;
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public Date getStartupTime() {
		return this.startupTime;
	}
	
	public void setStartupTime(Date startupTime) {
		this.startupTime = startupTime;
	}

	public String[] getChangeHandlerKeys() {
		return this.changeHandlerKeys;
	}

	public void setChangeHandlerKeys(String[] changeHandlerKeys) {
		this.changeHandlerKeys = changeHandlerKeys;
	}
}
  