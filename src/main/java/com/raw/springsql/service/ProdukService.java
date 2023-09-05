package com.raw.springsql.service;

import com.raw.springsql.entity.Produk;
import com.raw.springsql.repository.ProdukRepo;
import com.raw.springsql.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class ProdukService {

    private ProdukRepo produkRepo;

    @Autowired
    public ProdukService(ProdukRepo produkRepo){
        this.produkRepo = produkRepo;
    }

    public Boolean insertProduk(Produk produk){
        Produk produkResponse = produkRepo.save(produk);
        return !ObjectUtils.isEmpty(produkResponse);
    }

    public Optional<Produk> getDataProduk(Integer produkId){
        return produkRepo.findById(produkId);
    }
}
