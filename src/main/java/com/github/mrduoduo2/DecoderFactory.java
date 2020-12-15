package com.github.mrduoduo2;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import java.util.Base64;

public class DecoderFactory implements ProtocolCodecFactory {

    private final BufferDocoder bufferDecoder;
    private final BufferEncoder bufferEncoder;

    public DecoderFactory() {
        bufferDecoder = new BufferDocoder();
        bufferEncoder = new BufferEncoder();
    }


    @Override
    public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
        return bufferEncoder;
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
        return bufferDecoder;
    }
}
