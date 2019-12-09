package demo;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@SpringBootApplication
@RestController
public class DynamicDestinationSourceApplication {

	@Autowired
	private ObjectMapper jsonMapper;

	private final EmitterProcessor<Message<?>> processor = EmitterProcessor.create();

	public static void main(String[] args) {
		SpringApplication.run(DynamicDestinationSourceApplication.class, args);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/", method = POST, consumes = "*/*")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void handleRequest(@RequestBody String body, @RequestHeader(HttpHeaders.CONTENT_TYPE) Object contentType) throws Exception {
		Map<String, String> payload = jsonMapper.readValue(body, Map.class);
		String destinationName = payload.get("id");
		Message<?> message = MessageBuilder.withPayload(payload)
				.setHeader("spring.cloud.stream.sendto.destination", destinationName).build();
		processor.onNext(message);
	}

	@Bean
	public Supplier<Flux<Message<?>>> supplier() {
		return () -> processor;
	}

	//Following sink is used as test consumer. It logs the data received through the consumer.
	static class TestSink {

		private final Log logger = LogFactory.getLog(getClass());

		@Bean
		public Consumer<String> receive1() {
			return data -> logger.info("Data received from customer-1..." + data);
		}

		@Bean
		public Consumer<String> receive2() {
			return data -> logger.info("Data received from customer-2..." + data);
		}
	}
}
