package esbtest.test;

import java.io.Serializable;

public class ChangedConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	private String configKey;
	private String oldConfigValue;
	private String configValue;
	private ConfigOperation op;
	
	public ChangedConfig() {}

	public ChangedConfig(String configKey, String oldConfigValue, String configValue, ConfigOperation op) {
	    this.configKey = configKey;
		this.oldConfigValue = oldConfigValue;
		this.configValue = configValue;
		this.op = op;
	}

	public String getConfigKey() {
		return this.configKey;
	}
	
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}
	
	public String getConfigValue() {
		return this.configValue;
	}
	
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	
	public ConfigOperation getOp() {
		return this.op;
	}
	
	public void setOp(ConfigOperation op) {
		this.op = op;
	}

	public String getOldConfigValue() {
		return this.oldConfigValue;
	}

	public void setOldConfigValue(String oldConfigValue) {
		this.oldConfigValue = oldConfigValue;
	}
}
