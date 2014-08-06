/**
 * @Date 2014年8月6日
 * @version 1.0.0
 * Copyright (c) 2014
 */
package com.sdw.soft.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;

/**
 * 
 * @author syd
 */
public class NioServer1 implements Runnable{

	private static final int BUFFER_SIZE = 4096;
	
	private static final int BIND_PORT1 = 8888;
	private static final int BIND_PORT2 = 8889;
	
	private Selector selector;
	private ByteBuffer receiveBuffer = ByteBuffer.allocate(BUFFER_SIZE);//接收数据缓存区
	private ByteBuffer sendBuffer = ByteBuffer.allocate(BUFFER_SIZE);//发送数据缓冲区
	
	private ServerSocketChannel serverSocketChannel1;
	private ServerSocketChannel serverSocketChannel2;
	
	private SocketChannel socketChannel1;
	private SocketChannel socketChannel2;
	
	public void init(){
		try {
			selector = SelectorProvider.provider().openSelector();
			
			serverSocketChannel1 = ServerSocketChannel.open();
			serverSocketChannel1.configureBlocking(false);
			InetSocketAddress address = new InetSocketAddress("127.0.0.1", BIND_PORT1);
			serverSocketChannel1.socket().bind(address);
			serverSocketChannel1.register(selector, SelectionKey.OP_ACCEPT);
			
			serverSocketChannel2 = ServerSocketChannel.open();
			serverSocketChannel2.configureBlocking(false);
			InetSocketAddress address2 = new InetSocketAddress("127.0.0.1", BIND_PORT2);
			serverSocketChannel2.socket().bind(address2);
			serverSocketChannel2.register(selector, SelectionKey.OP_ACCEPT);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true){
			
		}
	}
}
