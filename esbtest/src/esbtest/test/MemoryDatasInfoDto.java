package esbtest.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MemoryDatasInfoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private long operationId;
	private String appName;
	private String ip;
	private HashMap<String, ChangedConfig> storeMap = new HashMap<String, ChangedConfig>();
	private List<ChangedConfig> storeList = new ArrayList<ChangedConfig>();
	private Date recordTime;

	public MemoryDatasInfoDto() {}

	public MemoryDatasInfoDto(long operationId, String appName, String ip, HashMap<String, ChangedConfig> storeMap, Date recordTime) {
		this.operationId = operationId;
		this.appName = appName;
		this.ip = ip;
		this.storeMap = storeMap;
		this.recordTime = recordTime;
	}

	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public long getOperationId() {
		return this.operationId;
	}

	public void setOperationId(long operationId) {
		this.operationId = operationId;
	}

	public String getAppName() {
		return this.appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public HashMap<String, ChangedConfig> getStoreMap() {
		return this.storeMap;
	}
	public void setStoreMap(HashMap<String, ChangedConfig> storeMap) {
		this.storeMap = storeMap;
	}

	public List<ChangedConfig> getStoreList() {
		return this.storeList;
	}

	public void setStoreList(List<ChangedConfig> storeList) {
		this.storeList = storeList;
	}

	public Date getRecordTime() {
		return this.recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
}
	