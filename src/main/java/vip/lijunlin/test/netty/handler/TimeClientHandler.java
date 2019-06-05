package vip.lijunlin.test.netty.handler;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import vip.lijunlin.test.netty.UnixTime;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {
	private ByteBuf buf;

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) {
		buf = ctx.alloc().buffer(4); // (1)
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) {
		buf.release(); // (1)
		buf = null;
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {

		UnixTime m = (UnixTime) msg;
		System.out.println(m);
		ctx.close();
		
//		ByteBuf m = (ByteBuf) msg; // (1)
//		buf.writeBytes(m); // (2)
//		try {
//			long currentTimeMillis = (buf.readUnsignedInt() - 2208988800L) * 1000L;
//			System.out.println(new Date(currentTimeMillis));
//			ctx.close();
//		} finally {
//			m.release();
//		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
