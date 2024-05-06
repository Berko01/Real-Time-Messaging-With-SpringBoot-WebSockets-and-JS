package beko.websocket.groupchat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupChatMessageService {
    private final GroupChatMessageRepository groupChatMessageRepository;

    public GroupChatMessage save(GroupChatMessage message) {
        return groupChatMessageRepository.save(message);
    }

    public List<GroupChatMessage> findMessagesByRoomId(String roomId) {
        return groupChatMessageRepository.findByRoomId(roomId);
    }
}
