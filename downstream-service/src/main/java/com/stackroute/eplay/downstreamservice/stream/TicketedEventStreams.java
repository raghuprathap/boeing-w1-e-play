package com.stackroute.eplay.downstreamservice.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TicketedEventStreams {
	String INPUT = "ticketed-event-in";
    @Input(INPUT)
    SubscribableChannel inboundTicketedEvent();
}
