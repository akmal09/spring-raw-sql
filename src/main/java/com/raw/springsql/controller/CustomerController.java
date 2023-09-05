package com.raw.springsql.controller;

import com.raw.springsql.entity.Card;
import com.raw.springsql.entity.Produk;
import com.raw.springsql.helper.BeliProdukReceiver;
import com.raw.springsql.response.ResponseObject;
import com.raw.springsql.service.CardService;
import com.raw.springsql.service.ProdukService;
import com.raw.springsql.service.TransaksiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final TransaksiService transaksiService;
    private final CardService cardService;

    private final ProdukService produkService;

    @Autowired
    public CustomerController(TransaksiService transaksiService, CardService cardService, ProdukService produkService){
        this.transaksiService = transaksiService;
        this.cardService = cardService;
        this.produkService = produkService;
    }

    @PostMapping("/beli-produk")
    public ResponseObject doTransaction(@RequestBody BeliProdukReceiver reqData){
        logger.info("controller "+ reqData.getCardId());
        Optional<Card> getCardData = cardService.getCardDataById(reqData.getCardId());
        Optional<Produk> getProdukData = produkService.getDataProduk(reqData.getProdukId());

        if(getCardData.isEmpty()) return new ResponseObject(403, "CARD NOT FOUND", false);

        if(getProdukData.isEmpty()) return new ResponseObject(403, "PRODUK NOT AVAILABLE", false);


        if(getCardData.get().getSaldo() < getProdukData.get().getHarga()) return new ResponseObject(402, "SALDO TIDAK CUKUP", false);

        getCardData.get().setSaldo(getCardData.get().getSaldo() - getProdukData.get().getHarga());

        Boolean dataSaved = cardService.insertCard(getCardData.get());

        if(!dataSaved) return new ResponseObject(500, "QUERY FAILED", false);

        return new ResponseObject(200, "SUCCESS", true);
    }
}
