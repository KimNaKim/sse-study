package com.metacoding.refsocket.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final ChatService chatService;

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

    // 4단계: /pub/room -> @MessageMapping -> @SendTo("/sub/chat")
    @SendTo("/sub/chat")
    @MessageMapping("/room")
    public ChatMessage pubTest2(ChatMessage message){
        return message;
    }


}






