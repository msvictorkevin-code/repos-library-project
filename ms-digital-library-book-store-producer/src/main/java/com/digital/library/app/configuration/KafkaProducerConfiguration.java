package com.digital.library.app.configuration;

import com.digital.library.app.model.LoanModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class KafkaProducerConfiguration {

   /* final KafkaProperties kafkaProperties;

    public KafkaProducerConfiguration(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }*/


    @Value("${custom.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean()
    public Map<String, Object> producerConfigs() {
        Map<String, Object> configProps = new HashMap<>();
        //Map<String, Object> configProps = new HashMap<>(kafkaProperties.buildProducerProperties());
         configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return configProps;
    }


    @Bean
    public ProducerFactory<String, LoanModel> loanProducerFactory() {

        return new DefaultKafkaProducerFactory<>(producerConfigs() );
    }

    @Bean()
    public KafkaTemplate<String, LoanModel> loanKafkaTemplate() {

        KafkaTemplate<String, LoanModel> kafkaTemplate = new KafkaTemplate<>(loanProducerFactory());

        kafkaTemplate.setProducerListener(new ProducerListener<String, LoanModel>() {

            @Override
            public void onSuccess(ProducerRecord<String, LoanModel> producerRecord, RecordMetadata recordMetadata) {
                log.info("Mensaje publicado con exito: {}  offset:  {}", producerRecord.value(), recordMetadata.offset());
            }

            @Override
            public void onError(ProducerRecord<String, LoanModel> producerRecord, RecordMetadata recordMetadata, Exception exception) {
                log.warn("Error al publicar el mensaje [{}] exception: {}", producerRecord.value(), exception.getMessage());
            }
        });
        return kafkaTemplate;
    }
}

