package vip.lijunlin.test.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 处理服务端 channel.
 */
public class AnswerServerHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
		ctx.write(msg); // (1)
        ctx.flush(); // (2)
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
		// 当出现异常就关闭连接
		cause.printStackTrace();
		ctx.close();
	}
}
