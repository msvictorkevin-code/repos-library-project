package com.digital.library.app.service.impl;

import com.digital.library.app.constants.Constants;
import com.digital.library.app.document.Reader;
import com.digital.library.app.dto.request.ReaderRequest;
import com.digital.library.app.dto.response.ReaderResponse;
import com.digital.library.app.exception.ServiceException;
import com.digital.library.app.repository.ReaderRepository;
import com.digital.library.app.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository readerRepository;


    @Transactional
    @Override
    public Mono<ReaderResponse> save(ReaderRequest readerRequest) throws ServiceException {
        try {
            Reader reader = new Reader();
            reader.setId(readerRequest.getId());
            reader.setIdReader(readerRequest.getIdReader());
            reader.setUserName(readerRequest.getUserName());
            reader.setReaderName(readerRequest.getReaderName());
            reader.setAddressReader(readerRequest.getAddressReader());
            reader.setUserProfileId(readerRequest.getUserProfileId());
            return readerRepository.save(reader).flatMap(x -> Mono.just(ReaderResponse.builder()
                    .idReader(x.getIdReader())
                    .userName(x.getUserName())
                    .readerName(x.getReaderName())
                    .addressReader(x.getAddressReader())
                    .userProfileId(x.getUserProfileId())
                    .status(true)
                    .message(Constants.INFO_SAVE_READER)
                    .build()));
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
