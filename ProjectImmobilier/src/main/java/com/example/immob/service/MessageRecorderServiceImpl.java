package com.example.immob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.immob.dao.MessageRecorderRepository;
import com.example.immob.entities.MessageRecorderEntity;


@Service
public class MessageRecorderServiceImpl implements MessageRecorderServiceInterface{
	
	private final MessageRecorderRepository messageRecorderRepo;

	@Autowired
	public MessageRecorderServiceImpl(MessageRecorderRepository messageRecorderRepo) {
		this.messageRecorderRepo = messageRecorderRepo;
	}
	
	@Override
	public void save(String sender, String receiver, String messageContent) {
		MessageRecorderEntity messageEntity = new MessageRecorderEntity();
		messageEntity.setSenderName(sender);
		messageEntity.setReceiverName(receiver);
		messageEntity.setMessageContent(messageContent);
		messageRecorderRepo.save(messageEntity);
	}

	@Override
	public List<MessageRecorderEntity> findAllByReceiverName(String receiverName) {
		List<MessageRecorderEntity> myMessages = messageRecorderRepo.findAllByReceiverName(receiverName);
		return myMessages;
	}
	
	
	

}
