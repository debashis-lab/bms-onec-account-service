package com.onec.bms.customer_account_service.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
@Schema(description = "Customer Account Information")
public class Account {
    
    @Id
    @Column(name = "account_number", unique = true, nullable = false)
    @Schema(description = "Unique account number", example = "ACC-12345")
    private String accountNumber;
    
    @Column(name = "account_type", nullable = false)
    @Schema(description = "Type of account", example = "SAVINGS")
    private String accountType;
    
    @Column(name = "account_status", nullable = false)
    @Schema(description = "Current status of the account", example = "ACTIVE")
    private String accountStatus;
    
    @Column(name = "account_balance", nullable = false)
    @Schema(description = "Current account balance", example = "1000.00")
    private String accountBalance;
    
    @Column(name = "account_currency", nullable = false)
    @Schema(description = "Account currency", example = "USD")
    private String accountCurrency;
    
    @Column(name = "account_opening_date")
    @Schema(description = "Date when account was opened", example = "2024-01-15")
    private String accountOpeningDate;
    
    @Column(name = "account_closing_date")
    @Schema(description = "Date when account was closed", example = "2024-12-31")
    private String accountClosingDate;
    
    @Column(name = "account_description")
    @Schema(description = "Description of the account", example = "Primary savings account")
    private String accountDescription;
    
    @Column(name = "account_branch")
    @Schema(description = "Branch where account is held", example = "MAIN_BRANCH")
    private String accountBranch;
    
    @Column(name = "account_customer_id", nullable = false)
    @Schema(description = "Customer ID associated with the account", example = "CUST-12345")
    private String accountCustomerId;
    
    @Column(name = "account_customer_name", nullable = false)
    @Schema(description = "Customer name", example = "John Doe")
    private String accountCustomerName;
    
    @Column(name = "account_customer_email")
    @Schema(description = "Customer email address", example = "john.doe@email.com")
    private String accountCustomerEmail;
    
    @Column(name = "account_customer_phone")
    @Schema(description = "Customer phone number", example = "+1-555-123-4567")
    private String accountCustomerPhone;
    
    @Column(name = "account_customer_address")
    @Schema(description = "Customer address", example = "123 Main St")
    private String accountCustomerAddress;
    
    @Column(name = "account_customer_city")
    @Schema(description = "Customer city", example = "New York")
    private String accountCustomerCity;
    
    @Column(name = "account_customer_state")
    @Schema(description = "Customer state", example = "NY")
    private String accountCustomerState;
    
    @Column(name = "account_customer_zip")
    @Schema(description = "Customer ZIP code", example = "10001")
    private String accountCustomerZip;

    // Default constructor
    public Account() {}

    // Constructor with all fields
    public Account(String accountNumber, String accountType, String accountStatus, 
                   String accountBalance, String accountCurrency, String accountOpeningDate,
                   String accountClosingDate, String accountDescription, String accountBranch,
                   String accountCustomerId, String accountCustomerName, String accountCustomerEmail,
                   String accountCustomerPhone, String accountCustomerAddress, String accountCustomerCity,
                   String accountCustomerState, String accountCustomerZip) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.accountBalance = accountBalance;
        this.accountCurrency = accountCurrency;
        this.accountOpeningDate = accountOpeningDate;
        this.accountClosingDate = accountClosingDate;
        this.accountDescription = accountDescription;
        this.accountBranch = accountBranch;
        this.accountCustomerId = accountCustomerId;
        this.accountCustomerName = accountCustomerName;
        this.accountCustomerEmail = accountCustomerEmail;
        this.accountCustomerPhone = accountCustomerPhone;
        this.accountCustomerAddress = accountCustomerAddress;
        this.accountCustomerCity = accountCustomerCity;
        this.accountCustomerState = accountCustomerState;
        this.accountCustomerZip = accountCustomerZip;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public String getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(String accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public String getAccountClosingDate() {
        return accountClosingDate;
    }

    public void setAccountClosingDate(String accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public String getAccountBranch() {
        return accountBranch;
    }

    public void setAccountBranch(String accountBranch) {
        this.accountBranch = accountBranch;
    }

    public String getAccountCustomerId() {
        return accountCustomerId;
    }

    public void setAccountCustomerId(String accountCustomerId) {
        this.accountCustomerId = accountCustomerId;
    }

    public String getAccountCustomerName() {
        return accountCustomerName;
    }

    public void setAccountCustomerName(String accountCustomerName) {
        this.accountCustomerName = accountCustomerName;
    }

    public String getAccountCustomerEmail() {
        return accountCustomerEmail;
    }

    public void setAccountCustomerEmail(String accountCustomerEmail) {
        this.accountCustomerEmail = accountCustomerEmail;
    }

    public String getAccountCustomerPhone() {
        return accountCustomerPhone;
    }

    public void setAccountCustomerPhone(String accountCustomerPhone) {
        this.accountCustomerPhone = accountCustomerPhone;
    }

    public String getAccountCustomerAddress() {
        return accountCustomerAddress;
    }

    public void setAccountCustomerAddress(String accountCustomerAddress) {
        this.accountCustomerAddress = accountCustomerAddress;
    }

    public String getAccountCustomerCity() {
        return accountCustomerCity;
    }

    public void setAccountCustomerCity(String accountCustomerCity) {
        this.accountCustomerCity = accountCustomerCity;
    }

    public String getAccountCustomerState() {
        return accountCustomerState;
    }

    public void setAccountCustomerState(String accountCustomerState) {
        this.accountCustomerState = accountCustomerState;
    }

    public String getAccountCustomerZip() {
        return accountCustomerZip;
    }

    public void setAccountCustomerZip(String accountCustomerZip) {
        this.accountCustomerZip = accountCustomerZip;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                ", accountCurrency='" + accountCurrency + '\'' +
                ", accountOpeningDate='" + accountOpeningDate + '\'' +
                ", accountClosingDate='" + accountClosingDate + '\'' +
                ", accountDescription='" + accountDescription + '\'' +
                ", accountBranch='" + accountBranch + '\'' +
                ", accountCustomerId='" + accountCustomerId + '\'' +
                ", accountCustomerName='" + accountCustomerName + '\'' +
                ", accountCustomerEmail='" + accountCustomerEmail + '\'' +
                ", accountCustomerPhone='" + accountCustomerPhone + '\'' +
                ", accountCustomerAddress='" + accountCustomerAddress + '\'' +
                ", accountCustomerCity='" + accountCustomerCity + '\'' +
                ", accountCustomerState='" + accountCustomerState + '\'' +
                ", accountCustomerZip='" + accountCustomerZip + '\'' +
                '}';
    }
}
