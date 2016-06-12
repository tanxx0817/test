package com.test.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HelloServerInHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		super.channelRead(ctx, msg);
		ByteBuf result = (ByteBuf) msg;
		byte[] result1 = new byte[result.readableBytes()];
		result.readBytes(result1);
		String str = new String(result1);
		System.out.println("client said: " + str);
		result.release();
		
		String res = "I'm ok";
		ByteBuf encoded = ctx.alloc().buffer(4 * res.length());
		encoded.writeBytes(res.getBytes());
		ctx.write(encoded);
		ctx.flush();
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		super.channelReadComplete(ctx);
//		ctx.flush();
	}
	
}
