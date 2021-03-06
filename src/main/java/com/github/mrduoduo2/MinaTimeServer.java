package com.github.mrduoduo2;

import org.apache.mina.core.filterchain.DefaultIoFilterChain;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class MinaTimeServer {
    public void Bind(Integer PORT) throws IOException {
        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();

        chain.addLast( "logger", new LoggingFilter() );
//        chain.addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory(StandardCharsets.UTF_8)));
        chain.addLast("codec",new ProtocolCodecFilter(new DecoderFactory()));

        acceptor.setHandler(  new TimeServerHandler() );
        acceptor.getSessionConfig().setReuseAddress(true);
        acceptor.getSessionConfig().setReadBufferSize( 20480000 );
        acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 100 );

        acceptor.bind( new InetSocketAddress(PORT) );
    }
}
