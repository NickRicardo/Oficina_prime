package com.oficinaPrime.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.oficinaPrime.backend.repository.ClientRepository;
import com.oficinaPrime.backend.repository.FinancialRecordRepository;
import com.oficinaPrime.backend.repository.ProductRepository;
import com.oficinaPrime.backend.repository.ReportRepository;
import com.oficinaPrime.backend.repository.SaleRepository;
import com.oficinaPrime.backend.repository.ServiceOrderRepository;

@Service
public class DBService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private FinancialRecordRepository financialRecordRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanciaDB() {

    }

}
