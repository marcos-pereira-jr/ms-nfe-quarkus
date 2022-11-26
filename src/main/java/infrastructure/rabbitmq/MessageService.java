package infrastructure.rabbitmq;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.reactive.streams.operators.PublisherBuilder;
import org.eclipse.microprofile.reactive.streams.operators.ReactiveStreams;

@ApplicationScoped
public class MessageService {

    @Outgoing("sourceA")
    public PublisherBuilder<String> send(String html) {
        return ReactiveStreams.of("html");
    }

}
