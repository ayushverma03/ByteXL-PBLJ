package partc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Transactional
    public void transferMoney(int fromId, int toId, double amount) {
        Account sender = accountDAO.findById(fromId);
        Account receiver = accountDAO.findById(toId);

        if (sender == null || receiver == null) {
            throw new RuntimeException("Account not found");
        }

        if (sender.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountDAO.update(sender);
        accountDAO.update(receiver);

        // If any exception occurs, @Transactional will roll back.
    }
}
