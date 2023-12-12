package com.csk.repository;

import com.csk.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author csk
 * @date 2023/11/27 10:22
 */
@Repository
public interface ChatRepository extends JpaRepository<ChatMessage, Integer> {
    @Query(value = "select * from chatmessage",nativeQuery = true)
    List<ChatMessage> findMessage();
}
