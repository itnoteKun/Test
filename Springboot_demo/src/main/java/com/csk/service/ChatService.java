package com.csk.service;

import com.csk.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author csk
 * @date 2023/11/27 10:31
 */
@Service
public interface ChatService {
    List<ChatMessage> addMessage(String username, String message);
    List<ChatMessage> listAll();
}
