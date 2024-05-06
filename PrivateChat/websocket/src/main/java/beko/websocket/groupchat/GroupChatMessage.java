package beko.websocket.groupchat;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupChatMessage {
    private String id;
    private String roomId;
    private String senderId;
    private String content;
    private Date timestamp;
}