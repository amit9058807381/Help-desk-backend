package com.spring.helpDesk.Help_desk_backend.controller;

import com.spring.helpDesk.Help_desk_backend.service.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/helpdesk")
@RequiredArgsConstructor
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://help-desk-frontend-sand.vercel.app"
})
public class AiController {


    private  final AiService service;

    @PostMapping
    public ResponseEntity<String >  getResponse(@RequestBody  String query, @RequestHeader("ConversationId") String conversationId){
        return ResponseEntity.ok(service.getResponseFromAssistant(query,conversationId));
    }


    @PostMapping(value = "/stream")
    public Flux<String> streamResponse(@RequestBody  String query, @RequestHeader("ConversationId") String conversationId){
        return this.service.streamResponseFromAssistant(query,conversationId) ;
    }



}