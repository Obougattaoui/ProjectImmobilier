package com.example.immob.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.immob.entities.MessageRecorderEntity;

@Repository
public interface MessageRecorderRepository extends JpaRepository<MessageRecorderEntity, Long>{
	List<MessageRecorderEntity> findAllByReceiverName(String receiverName);
}
