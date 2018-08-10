package com.stackroute.eplay.downstreamservice.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MovieStreams {
	String INPUT = "movie-in";
    @Input(INPUT)
    SubscribableChannel inboundMovie();
}
