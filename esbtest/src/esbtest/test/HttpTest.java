package esbtest.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpTest {
	
	static void smsHttp() {
		String url = "http://192.168.15.28:7001/esbsms/";
//		String url = "http://192.168.14.139:7001/esbsms/";
//		String url = "http://localhost:8888/esbsms";
//		String url = "http://sms-web.99bill.com/sms-web/sendSms.htm";
//		String url = "http://10.200.151.72:8091/sms-web/sendSms.htm";
		HttpClient httpClient = null;
		try {
			HttpPost http = new HttpPost(url);
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("mobile", "+8613581597412"));
			params.add(new BasicNameValuePair("content", "yyyyy谭晓羲"));
			
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "UTF-8");
			http.setEntity(formEntity);
			
			http.addHeader("serviceId", "0002000000001");
			
			http.addHeader("X-ESB-Client-Id", "A00000003"); //ITSM的应用ID，常量值
			http.addHeader("X-ESB-Service-Id", "0002000000001"); //ESB短信服务ID，常量值
			http.addHeader("X-ESB-Date-Time", "20150804165858"); //ITSM每次调用短信的时间，精确到秒，本例中表示：2015年8月4号16点58分58秒调用
			
			System.out.println("executing request:" + http.getURI());
			httpClient = new DefaultHttpClient();
			HttpResponse res = httpClient.execute(http);
			HttpEntity entity = res.getEntity();
			if (entity != null) {
                String content = EntityUtils.toString(entity, "UTF-8");  
                System.out.println("Response content:" + content);  
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != httpClient) {
				httpClient.getConnectionManager().shutdown();
			}
		}
	}
	
	static void postHttp() {
		String url = "http://192.168.52.221:8080/mas/internal/notifySMS/";
//		String url = "http://192.168.14.139:7001/esbsms/";
//		String url = "http://localhost:8888/esbsms";
//		String url = "http://sms-web.99bill.com/sms-web/sendSms.htm";
//		String url = "http://10.200.151.72:8091/sms-web/sendSms.htm";
		HttpClient httpClient = null;
		try {
			HttpPost http = new HttpPost(url);
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("mobile", "13581597412"));
			params.add(new BasicNameValuePair("content", "yyyyy谭晓羲"));
			params.add(new BasicNameValuePair("moTime", "20130527093101"));
			
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "UTF-8");
			http.setEntity(formEntity);
			
			System.out.println("executing request:" + http.getURI());
			httpClient = new DefaultHttpClient();
			HttpResponse res = httpClient.execute(http);
			HttpEntity entity = res.getEntity();
			if (entity != null) {
                String content = EntityUtils.toString(entity, "UTF-8");  
                System.out.println("Response content:" + content);  
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != httpClient) {
				httpClient.getConnectionManager().shutdown();
			}
		}
	}
	
	static void encryptHttp() {
		HttpClient httpClient = null;
		String url = "http://192.168.15.28:7002/baseservice/";
		try {
			HttpPost http = new HttpPost(url);
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("message", "123456"));
			params.add(new BasicNameValuePair("indexStr", "20016"));
			
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "UTF-8");
			http.setEntity(formEntity);
			
			http.addHeader("X-ESB-Client-Id", "A01100056"); //APP-RIP的应用ID，常量值
			http.addHeader("X-ESB-Service-Id", "0005000000001"); //ESB加密服务ID，常量值
			http.addHeader("X-ESB-Date-Time", "20150804165858"); //APP-RIP每次调用短信的时间，精确到秒，本例中表示：2015年8月4号16点58分58秒调用
//			http.addHeader("Content-Type","application/x-www-form-urlencoded; charset=\"utf-8\""); 
			
			/*HttpParams p = new BasicHttpParams();
			p.setParameter("serviceId", "1111111111111");
			p.setParameter("message", "6CD5B3109B0CE523");
			p.setParameter("indexStr", "20016");
			http.setParams(p);*/
			httpClient = new DefaultHttpClient();
			HttpResponse res = httpClient.execute(http);
			HttpEntity entity = res.getEntity();
			if (entity != null) {
//                String content = EntityUtils.toString(entity, "UTF-8");  
                String result = new String(EntityUtils.toString(entity).getBytes("ISO-8859-1"),"UTF-8");
                System.out.println("Response content:" + result);  
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != httpClient) {
				httpClient.getConnectionManager().shutdown();
			}
		}
	}
	
	static void decryptHttp() {
		HttpClient httpClient = null;
		String url = "http://192.168.15.28:7002/baseservice";
		try {
			HttpPost http = new HttpPost(url);
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("message", "F76FD32228DA94F3"));
			params.add(new BasicNameValuePair("indexStr", "20016"));
			
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "UTF-8");
			http.setEntity(formEntity);
			
			http.addHeader("X-ESB-Client-Id", "A01100056"); //APP-RIP的应用ID，常量值
			http.addHeader("X-ESB-Service-Id", "0005000000002"); //ESB解密服务ID，常量值
			http.addHeader("X-ESB-Date-Time", "20150804165858"); //APP-RIP每次调用短信的时间，精确到秒，本例中表示：2015年8月4号16点58分58秒调用
			
			/*HttpParams p = new BasicHttpParams();
			p.setParameter("serviceId", "1111111111111");
			p.setParameter("message", "6CD5B3109B0CE523");
			p.setParameter("indexStr", "20016");
			http.setParams(p);*/
			http.getParams().setParameter("charset", "UTF-8");
			httpClient = new DefaultHttpClient();
			HttpResponse res = httpClient.execute(http);
			HttpEntity entity = res.getEntity();
			if (entity != null) {
                String content = EntityUtils.toString(entity);  
                String result = new String(content.getBytes("ISO-8859-1"),"UTF-8");
                System.out.println("Response content:" + result);  
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != httpClient) {
				httpClient.getConnectionManager().shutdown();
			}
		}
	}
	
	static void mamHttp() {
//		String url = "http://192.168.47.62:7003/MAMIntegration"; //dev
//		String url = "http://192.168.14.210:7003/MAMIntegration"; //st2
		String url = "http://outteresb.99bill.com/MAMIntegration/"; //st2
//		String url = "http://192.168.15.31:8101/integration/http/default";
//		String url = "http://192.168.65.3:8082/integration/http/default";
//		String url = "http://192.168.15.31:8101/integration/http/default";
		HttpClient httpClient = null;
		try {
			HttpPost http = new HttpPost(url);
			//dev
			//String strJson = "{\"version\":\"1\",\"service\":\"ma.unifylogin.unifylogin\",\"requestId\":null,\"appId\":\"16\",\"loginType\":\"1001\",\"memberCode\":\"10012194153\",\"authId\":null,\"email\":null,\"mobile\":null,\"userId\":\"admin\",\"uId\":null,\"ipAddress\":\"192.168.173.92\",\"identityCard\":null,\"password\":\"123456yyy\",\"ivrPassword\":null,\"tokenPassword\":null,\"serverSeed\":null,\"certSignedMsg\":null,\"activexVersion\":null,\"matrixCardToken\":null,\"matrixCardSerialNo\":null,\"matrixCardValue1\":null,\"matrixCardValue2\":null,\"matrixCardValue3\":null}";
			//st2
			String strJson = "{\"version\":\"1\",\"service\":\"ma.unifylogin.unifylogin\",\"requestId\":\"1435822732102\",\"appId\":\"3\",\"loginType\":\"1001\",\"memberCode\":null,\"authId\":null,\"email\":\"unitedsignup060@qa.99bill.com\",\"mobile\":null,\"userId\":\"admin\",\"uId\":null,\"ipAddress\":\"192.168.20.63\",\"identityCard\":null,\"password\":\"aa123456\",\"ivrPassword\":null,\"tokenPassword\":null,\"serverSeed\":null,\"certSignedMsg\":null,\"activexVersion\":null,\"matrixCardToken\":null,\"matrixCardSerialNo\":null,\"matrixCardValue1\":null,\"matrixCardValue2\":null,\"matrixCardValue3\":null}";
			StringEntity strEntity = new StringEntity(strJson, ContentType.APPLICATION_JSON);
			http.setEntity(strEntity);
						
			http.addHeader("X-Client-Id", "0010001");
			http.addHeader("X-Service-Id", "MS402003");
			http.addHeader("X-ESB-Client-Id", "A01400021");
			http.addHeader("X-ESB-Service-Id",  "A002000351001");
			
			System.out.println("executing request:" + http.getURI());
			httpClient = new DefaultHttpClient();
			HttpResponse res = httpClient.execute(http);
			org.apache.http.Header[] headers = res.getAllHeaders();
			for (org.apache.http.Header header : headers) {
				System.out.println(header);
			}
//			System.out.println("header:" + res.get);
			HttpEntity entity = res.getEntity();
			if (entity != null) {
//                String content = EntityUtils.toString(entity, "UTF-8");  
                String result = new String(EntityUtils.toString(entity).getBytes("ISO-8859-1"),"UTF-8");
                System.out.println("Response content:" + result);  
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != httpClient) {
				httpClient.getConnectionManager().shutdown();
			}
		}
	}
	
	static void wsHttp() {
		HttpClient httpClient = null;
		String url = "http://192.168.137.42:8080/arsys/services/ARService?server=192.168.137.37&webService=ITSM_PLToITSM_Interface";
		
		try {
			HttpPost http = new HttpPost(url);
			
			StringBuffer sb = new StringBuffer("");
			sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:ITSM_PLToITSM_Interface\">");
			sb.append("   <soapenv:Header>");
			sb.append("      <urn:AuthenticationInfo>");
			sb.append("         <urn:userName>PL_Test_User</urn:userName>");
			sb.append("         <urn:password>PLPassword</urn:password>");
			sb.append("         <urn:authentication>?</urn:authentication>");
			sb.append("         <urn:locale>?</urn:locale>");
			sb.append("         <urn:timeZone>?</urn:timeZone>");
			sb.append("      </urn:AuthenticationInfo>");
			sb.append("   </soapenv:Header>");
			sb.append("   <soapenv:Body>");
			sb.append("      <urn:Create>");
			sb.append("         <urn:Problem_Investigation_ID>?</urn:Problem_Investigation_ID>");
			sb.append("         <urn:Temporary_Workaround>?</urn:Temporary_Workaround>");
			sb.append("         <urn:Implemented_Solution>?</urn:Implemented_Solution>");
			sb.append("      </urn:Create>");
			sb.append("   </soapenv:Body>");
			sb.append("</soapenv:Envelope>");
			
			StringEntity strEntity = new StringEntity(sb.toString());
			http.setEntity(strEntity);
			
			http.addHeader("SOAPAction", "urn:ITSM_PLToITSM_Interface/Create");
						
			System.out.println("executing request:" + http.getURI());
			httpClient = new DefaultHttpClient();
			HttpResponse res = httpClient.execute(http);
			System.out.println("=====" + res.getFirstHeader("Content-Type"));
			HttpEntity entity = res.getEntity();
			if (entity != null) {
                String content = EntityUtils.toString(entity, "UTF-8");  
                System.out.println("Response content:" + content);  
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != httpClient) {
				httpClient.getConnectionManager().shutdown();
			}
		}
	}
	
	/*public void httpJIAMI() {
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse re = null;
		HttpPost post = null;
		try {
			post = new HttpPost("http://192.168.15.28:7002/baseservice/");
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			list.add(new BasicNameValuePair("message", "123456"));
			list.add(new BasicNameValuePair("indexStr", "20016"));
			post.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
			post.addHeader("X-ESB-Client-Id", "A01100056");// APP-RIP的应用ID，常量值
			post.addHeader("X-ESB-Service-Id", "0005000000002");// ESB解密服务ID，常量值
			post.addHeader("X-ESB-Date-Time", "");// 每次调用接口的时间，精确到秒
			re = client.execute(post);
			System.out.println("status= " + re.getStatusLine().getStatusCode());
			System.out.println("result= " + EntityUtils.toString(re.getEntity(), "UTF-8"));
		} catch (Exception e) {
		} finally {
			if (re != null) {
				try {
					re.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}*/
	
	public static void main(String[] args) {
//		HttpTest.encryptHttp();
//		HttpTest.decryptHttp();
//		HttpTest.smsHttp();
//		HttpTest.mamHttp();
//		wsHttp();
//		testHttps();
		HttpTest.postHttp();
	}
}
