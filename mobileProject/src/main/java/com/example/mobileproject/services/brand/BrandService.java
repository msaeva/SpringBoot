package com.example.mobileproject.services.brand;

import com.example.mobileproject.repositories.BrandRepository;
import com.example.mobileproject.services.init.DataBaseInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService implements DataBaseInitService {
    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public boolean isDbInit() {
        return this.brandRepository.count() > 0;
    }

    @Override
    public void dbInit() {

    }
}
