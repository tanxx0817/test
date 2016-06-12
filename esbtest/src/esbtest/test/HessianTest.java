package esbtest.test;

import java.util.Date;
import java.util.HashMap;

import com.caucho.hessian.client.HessianProxyFactory;

public class HessianTest {
	
	static void crypt() {
//		String url = "http://192.168.126.244:8089/app-monitor-website/manager/cryptServ";
		String url = "http://192.168.15.29:9004/baseservice";
		HessianProxyFactory factory = new HessianProxyFactory();
        try {
            HessianCryptServ service = (HessianCryptServ) factory.create(HessianCryptServ.class, url);
            System.out.println(service.encryptMsg("123456", "20016"));//6CD5B3109B0CE523
            System.out.println(service.decryptMsg("6CD5B3109B0CE523", "20016"));//123456
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	static void acmsRetrieve() {
//		String url = "http://192.168.8.167/app-acms-server/hessian/configRetrieveService";
		String url = "http://192.168.15.29:8889/acms";
		HessianProxyFactory factory = new HessianProxyFactory();
//		ServiceContext c = ServiceContext.getContext();
//		c.addHeader("serviceId", "");
        try {
        	HessianConfigRetrieveService service = (HessianConfigRetrieveService) factory.create(HessianConfigRetrieveService.class, url);
        	HashMap<String, String> map = service.retriveConfig("app-fo-dps-quartz.queryICBCDirectPayT2UnknowStatusOrderJob.jobStartTimeout");
        	if (null != map) {
        		if (map.size() != 0) {
        			for (String key : map.keySet()) {
        				System.out.println("map, key is:" + key +", value is:" + map.get(key));
        			}
        		} else {
        			System.out.println("the size of map is 0");
        		}
        	} else {
        		System.out.println("map is null");
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	static void acmsRegister() {
		String url = "http://192.168.8.167/app-acms-server/hessian/appRegisterService";
		HessianProxyFactory factory = new HessianProxyFactory();
        try {
        	HessianAppRegisterService service = (HessianAppRegisterService) factory.create(HessianAppRegisterService.class, url);
        	String appName = "ESB";
        	String[] keyPatterns = new String[] {""};
        	String ip = "192.168.15.29";
        	String[] handlerKeys = new String[] {""};
        	Date date = new Date();
        	RegisterMsgDto dto = new RegisterMsgDto(appName, keyPatterns, ip, handlerKeys, date);
        	service.registerMsg(dto);
        	System.out.println("execute HessianAppRegisterService successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	static void acmsMemory() {
		String url = "http://192.168.8.167/app-acms-server/hessian/clientMemoryDatasRecordService";
		HessianProxyFactory factory = new HessianProxyFactory();
        try {
        	HessianClientMemoryDatasRecordService service = (HessianClientMemoryDatasRecordService) factory.create(HessianClientMemoryDatasRecordService.class, url);
        	
        	long operationId = 1L;
        	String appName = "ESB";
        	String ip = "192.168.15.29";
        	HashMap<String, ChangedConfig> map = new HashMap<String, ChangedConfig>();
        	Date date = new Date();
        	MemoryDatasInfoDto dto = new MemoryDatasInfoDto(operationId, appName, ip, map, date);
        	service.recordMemoryDatas(dto);
        	System.out.println("execute HessianClientMemoryDatasRecordService successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	static void acmsCallBack() {
		String url = "http://192.168.8.167/app-acms-server/hessian/clientCallBackDatasRecordService";
		HessianProxyFactory factory = new HessianProxyFactory();
        try {
        	MdpConfigForwardService service = (MdpConfigForwardService) factory.create(MdpConfigForwardService.class, url);
        	
        	service.sendDynConfig(1L, new HashMap<String, String>(), true);
        	System.out.println("execute acmsCallBack.sendDynConfig successfully");
        	
        	service.lookupClientStore(1L, "", true);
        	System.out.println("execute acmsCallBack.lookupClientStore.1 successfully");
        	
        	service.lookupClientStore(1L, "", "", true);
        	System.out.println("execute acmsCallBack.lookupClientStore.2 successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

    public static void main(String[] args) {
    	HessianTest.crypt();
//    	HessianTest.acmsRetrieve();
//    	HessianTest.acmsRegister();
//    	HessianTest.acmsMemory();
//    	HessianTest.acmsCallBack();
    }
}
