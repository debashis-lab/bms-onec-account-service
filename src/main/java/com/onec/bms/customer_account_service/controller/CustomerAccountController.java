package com.onec.bms.customer_account_service.controller;

import com.onec.bms.customer_account_service.model.Account;
import com.onec.bms.customer_account_service.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/accounts")
@Tag(name = "Customer Account Management", description = "CRUD operations for customer accounts")
public class CustomerAccountController {

    @Autowired
    private AccountService accountService;

    // Initialize with sample data
    public CustomerAccountController() {
        // Sample data will be initialized in the service
    }

    @GetMapping
    @Operation(summary = "Get all accounts", description = "Retrieve a list of all customer accounts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all accounts",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{accountNumber}")
    @Operation(summary = "Get account by account number", description = "Retrieve a specific customer account by its account number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account found successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class))),
            @ApiResponse(responseCode = "404", description = "Account not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Account> getAccountByNumber(
            @Parameter(description = "Account number", required = true, example = "ACC-000001")
            @PathVariable String accountNumber) {
        
        Optional<Account> account = accountService.getAccountByNumber(accountNumber);
        
        if (account.isPresent()) {
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Get accounts by customer ID", description = "Retrieve all accounts for a specific customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer accounts found successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class))),
            @ApiResponse(responseCode = "404", description = "No accounts found for customer"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Account>> getAccountsByCustomerId(
            @Parameter(description = "Customer ID", required = true, example = "CUST-001")
            @PathVariable String customerId) {
        
        List<Account> customerAccounts = accountService.getAccountsByCustomerId(customerId);
        
        if (customerAccounts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(customerAccounts);
    }

    @PostMapping
    @Operation(summary = "Create new account", description = "Create a new customer account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Account created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Account> createAccount(
            @Parameter(description = "Account details", required = true)
            @RequestBody Account account) {
        
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    @PutMapping("/{accountNumber}")
    @Operation(summary = "Update account", description = "Update an existing customer account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class))),
            @ApiResponse(responseCode = "404", description = "Account not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Account> updateAccount(
            @Parameter(description = "Account number", required = true, example = "ACC-000001")
            @PathVariable String accountNumber,
            @Parameter(description = "Updated account details", required = true)
            @RequestBody Account updatedAccount) {
        
        Optional<Account> account = accountService.updateAccount(accountNumber, updatedAccount);
        
        if (account.isPresent()) {
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{accountNumber}")
    @Operation(summary = "Delete account", description = "Delete a customer account by account number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<String> deleteAccount(
            @Parameter(description = "Account number", required = true, example = "ACC-000001")
            @PathVariable String accountNumber) {
        
        boolean deleted = accountService.deleteAccount(accountNumber);
        
        if (deleted) {
            return ResponseEntity.ok("Account " + accountNumber + " deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{accountNumber}/status")
    @Operation(summary = "Update account status", description = "Update only the status of an account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account status updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class))),
            @ApiResponse(responseCode = "404", description = "Account not found"),
            @ApiResponse(responseCode = "400", description = "Invalid status value"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Account> updateAccountStatus(
            @Parameter(description = "Account number", required = true, example = "ACC-000001")
            @PathVariable String accountNumber,
            @Parameter(description = "New account status", required = true, example = "SUSPENDED")
            @RequestBody String status) {
        
        Optional<Account> account = accountService.updateAccountStatus(accountNumber, status);
        
        if (account.isPresent()) {
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{accountNumber}/balance")
    @Operation(summary = "Update account balance", description = "Update the balance of an account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account balance updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class))),
            @ApiResponse(responseCode = "404", description = "Account not found"),
            @ApiResponse(responseCode = "400", description = "Invalid balance value"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Account> updateAccountBalance(
            @Parameter(description = "Account number", required = true, example = "ACC-000001")
            @PathVariable String accountNumber,
            @Parameter(description = "New account balance", required = true, example = "7500.00")
            @RequestBody String balance) {
        
        Optional<Account> account = accountService.updateAccountBalance(accountNumber, balance);
        
        if (account.isPresent()) {
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
