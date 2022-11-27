package infrastructure.rabbitmq;

import javax.enterprise.context.ApplicationScoped;

import io.smallrye.reactive.messaging.rabbitmq.OutgoingRabbitMQMetadata;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Metadata;

import java.time.ZonedDateTime;

@ApplicationScoped
public class MessageService {
    @Channel("brute_nfe")
    Emitter<String> emitter;

    final OutgoingRabbitMQMetadata metadata = new OutgoingRabbitMQMetadata.Builder()
            .withRoutingKey("*")
            .withTimestamp(ZonedDateTime.now())
            .build();

    public void send(String xml) {
        emitter.send(Message.of(xml, Metadata.of(metadata)));
        System.out.println("FOI");
    }
}
