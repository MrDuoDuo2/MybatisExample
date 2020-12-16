package com.github.mrduoduo2;

import com.github.mrduoduo2.models.SqlJson;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class BufferEncoder extends ProtocolEncoderAdapter {
    @Override
    public void encode(IoSession ioSession, Object message, ProtocolEncoderOutput protocolEncoderOutput) throws Exception {

        SqlJson result = (SqlJson) message;
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",result.getCODE());
        resultMap.put("message",result.getMESSAGE());
        resultMap.put("data",result.getDATA());
        String str = JsonUtils.toUpperCaseJson(resultMap);


        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        IoBuffer buffer = IoBuffer.allocate(bytes2.length, false);;
        buffer.setAutoExpand(true);
        buffer.put(bytes2);
        buffer.flip();
        protocolEncoderOutput.write(buffer);
    }
}
