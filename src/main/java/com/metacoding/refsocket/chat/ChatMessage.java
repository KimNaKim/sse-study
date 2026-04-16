package com.metacoding.refsocket.chat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ChatMessage {
    private String room;
    private String msg;
}
