package com.github.mrduoduo2;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.StandardCharsets;

public class BufferEncoder extends ProtocolEncoderAdapter {
    @Override
    public void encode(IoSession ioSession, Object message, ProtocolEncoderOutput protocolEncoderOutput) throws Exception {
        String str =(String)message;
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        IoBuffer buffer = IoBuffer.allocate(bytes2.length, false);;
        buffer.setAutoExpand(true);
        buffer.put(bytes2);
        buffer.flip();
        protocolEncoderOutput.write(buffer);
    }
}
