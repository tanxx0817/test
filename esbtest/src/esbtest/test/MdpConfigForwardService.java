package esbtest.test;

import java.util.HashMap;

public interface MdpConfigForwardService {
	public void sendDynConfig(long paramLong, HashMap<String, String> paramHashMap, boolean paramBoolean);

	public void lookupClientStore(long paramLong, String paramString, boolean paramBoolean);

	public void lookupClientStore(long paramLong, String paramString1, String paramString2, boolean paramBoolean);
}
