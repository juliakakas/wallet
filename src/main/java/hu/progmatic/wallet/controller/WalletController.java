package hu.progmatic.wallet.controller;

import hu.progmatic.wallet.model.Expense;
import hu.progmatic.wallet.model.Wallet;
import hu.progmatic.wallet.service.ExpenseService;
import hu.progmatic.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    private final WalletService walletService;
    private final ExpenseService expenseService;

    @Autowired
    public WalletController(WalletService walletService, ExpenseService expenseService) {
        this.walletService = walletService;
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

    @GetMapping("/wallet")
    public String getAllWallet(Model model) {
        model.addAttribute("wallets", walletService.getAllWallets());
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "wallet";
    }

    @GetMapping("/addWallet")
    public String addNewWallet(Model model) {
        model.addAttribute("newWallet", new Wallet());
        return "addWallet";
    }

    @PostMapping("/addWallet")
    public String addNewWallet(@ModelAttribute("newWallet") Wallet newWallet) {
        walletService.addNewWallet(newWallet);
        return "redirect:/wallet";
    }

    @GetMapping("/addExpense")
    public String addNewExpense(Model model) {
        model.addAttribute("newExpense", new Expense());
        return "addExpense";
    }

    @PostMapping("/addExpense")
    public String addNewExpense(@ModelAttribute("newExpense") Expense newExpense) {
        expenseService.addNewExpense(newExpense);
        return "redirect:/wallet";
    }



}
