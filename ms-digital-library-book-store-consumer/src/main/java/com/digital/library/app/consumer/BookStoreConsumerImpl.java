package com.digital.library.app.consumer;

import com.digital.library.app.model.LoanBookModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookStoreConsumerImpl implements BookStoreConsumer {

    @KafkaListener(
            topics = "${custom.kafka.topic-name}",
            groupId = "${custom.kafka.group-id}",
            containerFactory = "ordenKafkaListenerContainerFactory")

    @Override
    public void consumeMessage(LoanBookModel loanBookModel) {
        log.info("Consumer message [{}]", loanBookModel);
        // procesar el envio a postgres
        // orderCommand.enviar(orden);
    }


}
