package com.spring.helpDesk.Help_desk_backend.tools;

import com.spring.helpDesk.Help_desk_backend.entity.Ticket;
import com.spring.helpDesk.Help_desk_backend.service.TicketService;
import jakarta.servlet.Servlet;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private final TicketService ticketService;

    // create ticket tool
    @Tool(description = "This tool helps to create new ticket in database.")
    public Ticket createTicketTool(@ToolParam(description = "Ticket fields required to create new ticket") Ticket ticket) {
        try {
            System.out.println("going to create ticket");
            System.out.println(ticket);
            this.log.info("Creating a new ticket with id" + ticket.getId()  );
            return ticketService.createTicket(ticket);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("failed to create ticket");
            return null;
        }
    }


    // get ticket using username
    @Tool(description = "This tool helps to get ticket by email.")
    public Ticket getTicketByUserName(@ToolParam(description = " email id whose ticket is required ") String emailid) {
        return ticketService.getTicketByEmailId(emailid);
    }

    @Tool(description = "This tool helps to update ticket.")
    public Ticket updateTicket(@ToolParam(description = "new ticket fields required to update with ticket id.") Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

    // get current system time


    @Tool(description = "Returns current system date and time")
    public String getCurrentTime() {
        return LocalDateTime.now().toString();
    }



}