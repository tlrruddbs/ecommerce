package com.example.catalogservice.service;

import com.example.catalogservice.entity.CatalogEntity;
import com.example.catalogservice.entity.CatalogRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CatalogServiceImpl implements CatalogService{

    CatalogRepository catalogRepository;
    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository){
        this.catalogRepository = catalogRepository;
    }
    @Override
    public Iterable<CatalogEntity> getAllCatalogs() {
        return catalogRepository.findAll();
    }
}
