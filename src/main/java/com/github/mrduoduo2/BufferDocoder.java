package com.github.mrduoduo2;

import com.github.mrduoduo2.models.SqlJson;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.nio.charset.StandardCharsets;

public class BufferDocoder extends CumulativeProtocolDecoder {
    @Override
    protected boolean doDecode(IoSession ioSession, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        if (in.prefixedDataAvailable(4)) {
            int length = in.getInt();
            byte[] bytes = new byte[length];
            in.get(bytes);
            String str = new String(bytes, StandardCharsets.UTF_8);
            SqlJson json = JsonUtils.fromJson(str, SqlJson.class);
            out.write(json);
            return true;
        } else {
            return false;
        }
    }
}
