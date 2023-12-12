package com.csk.service;

import com.csk.repository.ChatRepository;
import com.csk.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author csk
 * @date 2023/11/27 10:38
 */
@Service
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository){
        this.chatRepository=chatRepository;
    }
    @Override
    public List<ChatMessage> addMessage(String username, String message) {
        ChatMessage chatMessage = new ChatMessage(username,message);
        chatRepository.saveAndFlush(chatMessage);
        return chatRepository.findAll();
    }

    @Override
    public List<ChatMessage> listAll() {
        return chatRepository.findAll();
    }

}
