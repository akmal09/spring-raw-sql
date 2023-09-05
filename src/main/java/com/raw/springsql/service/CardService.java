package com.raw.springsql.service;

import com.raw.springsql.entity.Card;
import com.raw.springsql.repository.CardRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class CardService {


    private static final Logger logger = LoggerFactory.getLogger(CardService.class);
    private CardRepo cardRepo;

    @Autowired
    public CardService(CardRepo cardRepo){
        this.cardRepo = cardRepo;
    }

    public boolean insertCard(Card card){
        Card cardResponse = cardRepo.save(card);
        return !ObjectUtils.isEmpty(cardResponse);
    }

    public Optional<Card> getCardDataById(Integer cardId){
        Optional<Card> getCard = cardRepo.findById(cardId);
//        logger.info("check data kartu "+getCard+ "\n status:"+getCard.isPresent());
        if(!getCard.isPresent()) return getCard;

        return getCard;
    }

}
