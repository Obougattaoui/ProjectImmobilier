package com.example.immob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.immob.entities.AppUser;
import com.example.immob.entities.MessageEntity;
import com.example.immob.entities.MessageRecorderEntity;
import com.example.immob.service.AccountService;
import com.example.immob.service.MessageRecorderServiceInterface;

@RestController
public class MessageController {
	
	private final AccountService accountService;
	
	private final SimpMessagingTemplate simpMessagingTemplate;
	
	private final MessageRecorderServiceInterface messageRecorder;
	
	@Autowired
	public MessageController(AccountService accountService, SimpMessagingTemplate simpMessagingTemplate, MessageRecorderServiceInterface messageRecorder) {
		this.accountService = accountService;
		this.simpMessagingTemplate = simpMessagingTemplate;
		this.messageRecorder = messageRecorder;
	}
	
	@MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageEntity message) {
		AppUser destination = accountService.findUserByUsername(to);
		AppUser sender = accountService.findUserByUsername(message.getFromLogin());
		int control = 0;
        if (destination.getId() != null) {
        	try {
        		Boolean blockControl = accountService.blockControl(destination.getUsername(), sender.getUsername());
        		if(blockControl.equals(Boolean.TRUE)) {
        			control=1;
        			throw new Exception("You can not sent message " + to);
        		}
        	}
        	catch(Exception e) {
        		if(control==0) {
        			simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        			messageRecorder.save(message.getFromLogin(), destination.getUsername(), message.getMessage());
        		}
        		control=1;
        	}
        	if(control==0) {
        		simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
    			messageRecorder.save(message.getFromLogin(), destination.getUsername(), message.getMessage());
        	}        
        }
    }
	
	@GetMapping("/mymessages")
	public List<MessageRecorderEntity> getMyMessages(@RequestParam String receiverName) throws Exception{
		AppUser user = accountService.findUserByUsername(receiverName);
		if(user.getId() == null) {
			throw new Exception("There is no user with this " + user.getUsername() + "user name!");
		}
		List<MessageRecorderEntity> response = messageRecorder.findAllByReceiverName(receiverName);
		return response;
		
	}

}
