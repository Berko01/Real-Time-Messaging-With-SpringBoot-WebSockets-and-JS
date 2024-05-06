package beko.websocket.groupchatroom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupChatRoomService {
    private final GroupChatRoomRepository groupChatRoomRepository;

    public GroupChatRoom createGroupChatRoom(String name, List<String> memberIds) {
        return groupChatRoomRepository.save(GroupChatRoom.builder()
                .name(name)
                .memberIds(memberIds)
                .build());
    }

    public Optional<GroupChatRoom> findGroupChatRoomByName(String name) {
        return groupChatRoomRepository.findByName(name);
    }

    public GroupChatRoom addUserToGroupChatRoom(String roomId, String userId) {
        Optional<GroupChatRoom> optionalGroupChatRoom = groupChatRoomRepository.findById(roomId);
        if (optionalGroupChatRoom.isPresent()) {
            GroupChatRoom groupChatRoom = optionalGroupChatRoom.get();
            groupChatRoom.getMemberIds().add(userId);
            return groupChatRoomRepository.save(groupChatRoom);
        }
        return null;
    }

    public GroupChatRoom removeUserFromGroupChatRoom(String roomId, String userId) {
        Optional<GroupChatRoom> optionalGroupChatRoom = groupChatRoomRepository.findById(roomId);
        if (optionalGroupChatRoom.isPresent()) {
            GroupChatRoom groupChatRoom = optionalGroupChatRoom.get();
            groupChatRoom.getMemberIds().remove(userId);
            return groupChatRoomRepository.save(groupChatRoom);
        }
        return null;
    }
}