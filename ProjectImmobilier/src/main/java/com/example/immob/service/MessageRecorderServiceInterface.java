package com.example.immob.service;

import java.util.List;

import com.example.immob.entities.MessageRecorderEntity;


public interface MessageRecorderServiceInterface {
	
	void save(String sender, String receiver, String messageContent);
	
	List<MessageRecorderEntity> findAllByReceiverName(String receiverName);
}

