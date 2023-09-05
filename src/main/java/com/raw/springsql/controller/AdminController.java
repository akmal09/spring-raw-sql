package com.raw.springsql.controller;

import com.raw.springsql.entity.Card;
import com.raw.springsql.entity.Produk;
import com.raw.springsql.helper.UpdateMemberReceiver;
import com.raw.springsql.response.ResponseObject;
import com.raw.springsql.service.CardService;
import com.raw.springsql.service.ProdukService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    private final ProdukService produkService;
    private final CardService cardService;

    public AdminController(ProdukService produkService, CardService cardService){
        this.produkService = produkService;
        this.cardService = cardService;
    }

    @PostMapping("/tambah-produk")
    public ResponseObject addProducts(@RequestBody Produk produk){
        logger.info("param tambahProduk : "+produk);
        Boolean isProductSaved = produkService.insertProduk(produk);

        if(!isProductSaved){
            return new ResponseObject(500, "ERROR",isProductSaved);
        }
        return new ResponseObject(200, "OK",isProductSaved);
    }

    @PostMapping("/tambah-kartu")
    public ResponseObject addCard(@RequestBody Card card){
        boolean cardResponse = cardService.insertCard(card);
        if(!cardResponse) return new ResponseObject(500, "ERROR", cardResponse);
        return new ResponseObject(200, "OK", cardResponse);
    }

    @PostMapping("/update-membership")
    public ResponseObject updateMembership(@RequestBody UpdateMemberReceiver updateMemberReceiver){
        Optional<Card> cardData = cardService.getCardDataById(updateMemberReceiver.getCardId());

        if(cardData.isEmpty()) return new ResponseObject(404, "CARD NOT FOUND", false);

        cardData.get().setJenis("gold");
        Boolean memberUpdated = cardService.insertCard(cardData.get());

        if(!memberUpdated) return new ResponseObject(500, "QUERY FAIL", false);
        return new ResponseObject(200, "OK", true);
    }
}
