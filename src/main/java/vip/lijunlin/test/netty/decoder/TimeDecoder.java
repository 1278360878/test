package vip.lijunlin.test.netty.decoder;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import vip.lijunlin.test.netty.UnixTime;

public class TimeDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		if (in.readableBytes() < 4) {
			return; // (3)
		}
//		out.add(in.readBytes(4)); // (4)
		out.add(new UnixTime(in.readUnsignedInt()));
	}

}
