package com.digital.library.app.producer;

import com.digital.library.app.model.LoanModel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookStoreProducerImpl implements BookStoreProducer {

    @Value("${custom.kafka.topic-name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, LoanModel> loanKafkaTemplate;

    @Override
    public void sendMessage(LoanModel loanModel) {
        log.info("send Loan Model", loanModel);
        log.info("topicName", topicName);
        loanKafkaTemplate.send(topicName, loanModel);
    }
}

