package com.digital.library.app.consumer;

import com.digital.library.app.model.LoanBookModel;

public interface BookStoreConsumer {
    public void consumeMessage(LoanBookModel loanBookModel);


}
