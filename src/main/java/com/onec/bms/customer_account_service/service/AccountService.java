package com.onec.bms.customer_account_service.service;

import com.onec.bms.customer_account_service.model.Account;
import com.onec.bms.customer_account_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * Get all accounts
     * @return List of all accounts
     */
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Get account by account number
     * @param accountNumber the account number
     * @return Optional containing the account if found
     */
    public Optional<Account> getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    /**
     * Get all accounts for a specific customer
     * @param customerId the customer ID
     * @return List of accounts for the customer
     */
    public List<Account> getAccountsByCustomerId(String customerId) {
        return accountRepository.findByAccountCustomerId(customerId);
    }

    /**
     * Create a new account
     * @param account the account to create
     * @return the created account
     */
    public Account createAccount(Account account) {
        // Generate account number if not provided
        if (account.getAccountNumber() == null || account.getAccountNumber().isEmpty()) {
            account.setAccountNumber(generateAccountNumber());
        }
        
        // Set default values
        if (account.getAccountStatus() == null || account.getAccountStatus().isEmpty()) {
            account.setAccountStatus("ACTIVE");
        }
        
        if (account.getAccountOpeningDate() == null || account.getAccountOpeningDate().isEmpty()) {
            account.setAccountOpeningDate(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
        
        if (account.getAccountCurrency() == null || account.getAccountCurrency().isEmpty()) {
            account.setAccountCurrency("USD");
        }
        
        return accountRepository.save(account);
    }

    /**
     * Update an existing account
     * @param accountNumber the account number
     * @param updatedAccount the updated account data
     * @return Optional containing the updated account if found
     */
    public Optional<Account> updateAccount(String accountNumber, Account updatedAccount) {
        Optional<Account> existingAccount = accountRepository.findByAccountNumber(accountNumber);
        
        if (existingAccount.isPresent()) {
            Account account = existingAccount.get();
            
            // Update fields (preserve account number)
            account.setAccountType(updatedAccount.getAccountType());
            account.setAccountStatus(updatedAccount.getAccountStatus());
            account.setAccountBalance(updatedAccount.getAccountBalance());
            account.setAccountCurrency(updatedAccount.getAccountCurrency());
            account.setAccountClosingDate(updatedAccount.getAccountClosingDate());
            account.setAccountDescription(updatedAccount.getAccountDescription());
            account.setAccountBranch(updatedAccount.getAccountBranch());
            account.setAccountCustomerId(updatedAccount.getAccountCustomerId());
            account.setAccountCustomerName(updatedAccount.getAccountCustomerName());
            account.setAccountCustomerEmail(updatedAccount.getAccountCustomerEmail());
            account.setAccountCustomerPhone(updatedAccount.getAccountCustomerPhone());
            account.setAccountCustomerAddress(updatedAccount.getAccountCustomerAddress());
            account.setAccountCustomerCity(updatedAccount.getAccountCustomerCity());
            account.setAccountCustomerState(updatedAccount.getAccountCustomerState());
            account.setAccountCustomerZip(updatedAccount.getAccountCustomerZip());
            
            return Optional.of(accountRepository.save(account));
        }
        
        return Optional.empty();
    }

    /**
     * Update account status
     * @param accountNumber the account number
     * @param status the new status
     * @return Optional containing the updated account if found
     */
    public Optional<Account> updateAccountStatus(String accountNumber, String status) {
        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
        
        if (account.isPresent()) {
            account.get().setAccountStatus(status);
            return Optional.of(accountRepository.save(account.get()));
        }
        
        return Optional.empty();
    }

    /**
     * Update account balance
     * @param accountNumber the account number
     * @param balance the new balance
     * @return Optional containing the updated account if found
     */
    public Optional<Account> updateAccountBalance(String accountNumber, String balance) {
        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
        
        if (account.isPresent()) {
            account.get().setAccountBalance(balance);
            return Optional.of(accountRepository.save(account.get()));
        }
        
        return Optional.empty();
    }

    /**
     * Delete an account
     * @param accountNumber the account number
     * @return true if account was deleted, false if not found
     */
    public boolean deleteAccount(String accountNumber) {
        if (accountRepository.existsByAccountNumber(accountNumber)) {
            accountRepository.deleteByAccountNumber(accountNumber);
            return true;
        }
        return false;
    }

    /**
     * Check if account exists
     * @param accountNumber the account number
     * @return true if account exists, false otherwise
     */
    public boolean accountExists(String accountNumber) {
        return accountRepository.existsByAccountNumber(accountNumber);
    }

    /**
     * Generate a unique account number
     * @return generated account number
     */
    private String generateAccountNumber() {
        long count = accountRepository.count();
        return "ACC-" + String.format("%06d", count + 1);
    }

    /**
     * Initialize sample data
     */
    public void initializeSampleData() {
        if (accountRepository.count() == 0) {
            Account account1 = new Account(
                    "ACC-000001", "SAVINGS", "ACTIVE", "5000.00", "USD",
                    "2024-01-15", null, "Primary savings account", "MAIN_BRANCH",
                    "CUST-001", "John Doe", "john.doe@email.com", "+1-555-123-4567",
                    "123 Main St", "New York", "NY", "10001"
            );
            
            Account account2 = new Account(
                    "ACC-000002", "CHECKING", "ACTIVE", "2500.00", "USD",
                    "2024-02-20", null, "Business checking account", "DOWNTOWN_BRANCH",
                    "CUST-002", "Jane Smith", "jane.smith@email.com", "+1-555-987-6543",
                    "456 Oak Ave", "Los Angeles", "CA", "90210"
            );
            
            accountRepository.save(account1);
            accountRepository.save(account2);
        }
    }
}
