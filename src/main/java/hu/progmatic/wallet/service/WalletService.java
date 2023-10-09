package hu.progmatic.wallet.service;

import hu.progmatic.wallet.model.Wallet;
import hu.progmatic.wallet.repository.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {
    private final WalletRepo walletRepo;

    @Autowired
    public WalletService(WalletRepo walletRepo) {
        this.walletRepo = walletRepo;
    }

    public List<Wallet> getAllWallets() {
        return walletRepo.findAll();
    }

    public void addNewWallet(Wallet wallet) {
        walletRepo.save(wallet);
    }

    public Wallet getWalletById(Long id) {
        return walletRepo.findById(id).orElse(null);
    }

}
