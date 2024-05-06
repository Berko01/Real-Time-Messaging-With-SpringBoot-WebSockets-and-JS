package beko.websocket.groupchatroom;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface GroupChatRoomRepository extends MongoRepository<GroupChatRoom, String> {
    Optional<GroupChatRoom> findByName(String name);
    List<GroupChatRoom> findByUserIdsContaining(String userId);
}
