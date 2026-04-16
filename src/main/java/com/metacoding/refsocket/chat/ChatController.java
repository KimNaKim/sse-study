package com.metacoding.refsocket.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final ChatService chatService;
    private final SimpMessageSendingOperations sms;

    @GetMapping("/save-form")
    public String saveForm(){
        return "save-form";
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("models", chatService.findAll());
        return "index";
    }

//    @PostMapping("/chat")
//    public String save(String msg){
//        Chat chat = chatService.save(msg);
//        sms.convertAndSend("/sub/chat", chat);
//        return "redirect:/";
//    }

    // 5단계: /pub/room -> @MessageMapping -> convertAndSend("/sub/{room}")
    @MessageMapping("/room")
    public void pubTest2(ChatMessage message){
        String room = message == null || message.getRoom() == null || message.getRoom().isBlank()
                ? "chat"
                : message.getRoom().trim();
        sms.convertAndSend("/sub/" + room, message);
    }


}






