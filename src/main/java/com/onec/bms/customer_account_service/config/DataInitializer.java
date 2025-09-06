package com.onec.bms.customer_account_service.config;

import com.onec.bms.customer_account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        // Initialize sample data when the application starts
        accountService.initializeSampleData();
    }
}
