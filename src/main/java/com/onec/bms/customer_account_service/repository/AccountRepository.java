package com.onec.bms.customer_account_service.repository;

import com.onec.bms.customer_account_service.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    
    /**
     * Find account by account number
     * @param accountNumber the account number
     * @return Optional containing the account if found
     */
    Optional<Account> findByAccountNumber(String accountNumber);
    
    /**
     * Find all accounts for a specific customer
     * @param customerId the customer ID
     * @return List of accounts for the customer
     */
    List<Account> findByAccountCustomerId(String customerId);
    
    /**
     * Find accounts by account type
     * @param accountType the account type (SAVINGS, CHECKING, etc.)
     * @return List of accounts with the specified type
     */
    List<Account> findByAccountType(String accountType);
    
    /**
     * Find accounts by account status
     * @param accountStatus the account status (ACTIVE, INACTIVE, SUSPENDED, etc.)
     * @return List of accounts with the specified status
     */
    List<Account> findByAccountStatus(String accountStatus);
    
    /**
     * Find accounts by branch
     * @param branch the branch name
     * @return List of accounts in the specified branch
     */
    List<Account> findByAccountBranch(String branch);
    
    /**
     * Find accounts by customer name (case-insensitive)
     * @param customerName the customer name
     * @return List of accounts for customers with the specified name
     */
    List<Account> findByAccountCustomerNameContainingIgnoreCase(String customerName);
    
    /**
     * Find accounts by customer email
     * @param email the customer email
     * @return List of accounts for customers with the specified email
     */
    List<Account> findByAccountCustomerEmail(String email);
    
    /**
     * Check if account exists by account number
     * @param accountNumber the account number
     * @return true if account exists, false otherwise
     */
    boolean existsByAccountNumber(String accountNumber);
    
    /**
     * Delete account by account number
     * @param accountNumber the account number
     */
    void deleteByAccountNumber(String accountNumber);
}
