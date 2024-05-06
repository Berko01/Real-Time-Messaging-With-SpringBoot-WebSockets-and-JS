package beko.websocket.groupchat;

import beko.websocket.groupchatroom.GroupChatRoom;
import beko.websocket.groupchatroom.GroupChatRoomRequest;
import beko.websocket.groupchatroom.GroupChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group-chat")
@RequiredArgsConstructor
public class GroupChatController {
    private final GroupChatRoomService groupChatRoomService;

    @PostMapping("/create")
    public ResponseEntity<GroupChatRoom> createGroupChatRoom(@RequestBody GroupChatRoomRequest request) {
        GroupChatRoom groupChatRoom = groupChatRoomService.createGroupChatRoom(request.getName(), request.getMemberIds());
        return ResponseEntity.ok(groupChatRoom);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<GroupChatRoom> findGroupChatRoomByName(@PathVariable String name) {
        return groupChatRoomService.findGroupChatRoomByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
