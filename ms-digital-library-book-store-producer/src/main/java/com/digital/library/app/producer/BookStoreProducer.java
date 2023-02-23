package com.digital.library.app.producer;

import com.digital.library.app.model.LoanModel;

public interface BookStoreProducer {

    public void sendMessage(LoanModel loanModel);
}
