package esbtest.test;

public interface HessianCryptServ {
	public String encryptMsg(String message, String indexStr) throws Exception;
    public String decryptMsg(String message, String indexStr) throws Exception;
}
