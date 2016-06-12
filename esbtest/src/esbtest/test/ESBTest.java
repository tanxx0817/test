package esbtest.test;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.mytools.enums.CharSetEnum;
import com.mytools.utils.InputStreamUtil;

/**
 * @author ping.huang
 * 创建时间 ：2015年5月21日 下午3:39:40
 * 类描述：
 */
public class ESBTest {

	
Logger log = Logger.getLogger(getClass());

	
@Test
public void httpsms1() {
	HttpClient client = new HttpClient();
	PostMethod post = new PostMethod("http://192.168.15.28:7001/esbsms/");
	try {
		/*Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
		Protocol.registerProtocol("https", myhttps);*/
		post.addParameter("mobile", "13585646412");
		post.addParameter("content", "测试11222");
		post.addRequestHeader("X-ESB-Service-Id", "0002000000001");//被调用的服务的服务编号
		post.addRequestHeader("X-ESB-Client-Id", "A00000001");//调用方自己平台编号
		client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");
		int code = client.executeMethod(post);
		System.out.println("status= " + code);
		System.out.println("result= " + post.getResponseBodyAsString());
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		post.releaseConnection();
	}
}
	
	@Test
	public void httpsms() {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("https://inneresb.99bill.net/esbsms/");
		try {
			Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
			Protocol.registerProtocol("https", myhttps);
			post.addParameter("mobile", "13585646412");
			post.addParameter("content", "测试11222");
			post.addRequestHeader("X-ESB-Service-Id", "0002000000001");//被调用的服务的服务编号
			post.addRequestHeader("X-ESB-Client-Id", "A00000001");//调用方自己平台编号
			client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");
			int code = client.executeMethod(post);
			System.out.println("status= " + code);
			System.out.println("result= " + post.getResponseBodyAsString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			post.releaseConnection();
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void ehr() {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://192.168.15.28:7000/esbehr/");
//		PostMethod post = new PostMethod("https://inneresb.99bill.net/esbehr/");
		try {
			Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
			Protocol.registerProtocol("https", myhttps);
			post.addRequestHeader("X-ESB-Client-Id", "A00000001");
			post.addRequestHeader("X-ESB-Service-Id", "0001000000001");
			post.setRequestBody(new FileInputStream("D:/lib/getPersonInfoByAccount.txt"));
			client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
			int code = client.executeMethod(post);
			InputStream in = post.getResponseBodyAsStream();
			System.out.println("status= " + code);
			System.out.println(InputStreamUtil.inputStreamToString(in, CharSetEnum.GBK.getValue()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			post.releaseConnection();
		}
	}
}
