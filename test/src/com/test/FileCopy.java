package com.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopy {
	public final static String FILE_FROM = "D:/downloads/Project_Pro_2010_W32.rar";
    public final static String FILE_TO = "E:/Project_Pro_2010_W32.rar";
		 
    public static void copyByOIOStream() throws Exception {
    	long beginTime = System.currentTimeMillis();
    	FileInputStream fis = null;
        FileOutputStream fos = null;
    	try {
    		fis = new FileInputStream(new File(FILE_FROM));
            fos = new FileOutputStream(new File(FILE_TO));
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            fos.flush();
    	} catch (IOException e) {
    		e.printStackTrace();
    	} finally {
    		fis.close();
            fos.close();
    	}
        long endTime = System.currentTimeMillis();
        System.out.println("copy a file by traditional IO FileInputStream, time elapsed:" + (endTime - beginTime));
    }
		 
    public static void copyByOIOBufferedStream() throws Exception {
        long beginTime = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
        	fis = new FileInputStream(new File(FILE_FROM));
            fos = new FileOutputStream(new File(FILE_TO));
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            bos.flush();
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
        	fis.close();
            fos.close();
            bis.close();
            bos.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("copy a file by traditional IO BufferedInputStream, time elapsed:" + (endTime - beginTime));
    }
		 
    public static void copyByOIOBuffered() throws Exception {
        long beginTime = System.currentTimeMillis();
        Reader br = null;;
        Writer bw = null;
        try {
        	br = new BufferedReader(new FileReader(new File(FILE_FROM)));
            bw = new BufferedWriter(new FileWriter(new File(FILE_TO)));
            char[] c = new char[1024];
            int len = 0;
            while ((len = br.read(c)) != -1) {
                bw.write(c, 0, len);
            }
            bw.flush();
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
        	br.close();
            bw.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("copy a file by traditional IO BufferedReader, time elapsed:" + (endTime - beginTime));
    }
		 
    public static void copyByOIORandomAccFile() throws Exception {
        long beginTime = System.currentTimeMillis();
        FileInputStream fis = null;
        RandomAccessFile raf = null;
        try {
        	fis = new FileInputStream(new File(FILE_FROM));
            raf = new RandomAccessFile(new File(FILE_TO), "rw");
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = fis.read(b)) != -1) {
                raf.write(b, 0, len);
            }
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
        	fis.close();
        	raf.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("copy a file by traditional IO RandomAccessFile, time elapsed:" + (endTime - beginTime));
    }
		 
    public static void copyByNioFileChannel() throws Exception {
        long beginTime = System.currentTimeMillis();
        FileChannel fcIn = null;
        FileChannel fcOut = null;
        try {
        	 fcIn = new FileInputStream(new File(FILE_FROM)).getChannel();
             fcOut = new RandomAccessFile(new File(FILE_TO), "rw").getChannel();
             fcOut.transferFrom(fcIn, 0, fcIn.size());
        } catch (IOException e) {
        	e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("copy a file by NIO FileChannel's zero copy mechanism, time elapsed:" + (endTime - beginTime));
    }
 
    public static void TransByNioFileChannelCommon() throws Exception {
        long beginTime = System.currentTimeMillis();
        FileChannel fc = null;
        FileChannel fco = null;
        FileInputStream fis = null;
        RandomAccessFile raf = null;
        try {
        	fis = new FileInputStream(new File(FILE_FROM));
			fc = fis.getChannel();
			raf = new RandomAccessFile(new File(FILE_TO), "rw");
			fco = raf.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (fc.read(buf) != -1) {
                buf.flip();
                fco.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
        	raf.close();
        	fis.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("copy a file by NIO FileChannel with FileInputStream and RandomAccessFile, time elapsed:" + (endTime - beginTime));
    }
		 
    public static void deleteFile() {
        File f = new File(FILE_TO);
        if (f.exists())
            f.delete();
    }
 
    public static void main(String[] args) throws Exception {
    	copyByOIOStream();
        deleteFile();
        copyByOIOBufferedStream();
        deleteFile();
        copyByOIOBuffered();
        deleteFile();
        copyByOIORandomAccFile();
        deleteFile();
        TransByNioFileChannelCommon();
        deleteFile();
    }
}
