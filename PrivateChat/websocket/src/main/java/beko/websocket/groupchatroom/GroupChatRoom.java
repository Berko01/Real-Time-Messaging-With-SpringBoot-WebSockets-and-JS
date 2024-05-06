package beko.websocket.groupchatroom;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupChatRoom {
    private String id;
    private String name;
    private List<String> memberIds;
}

