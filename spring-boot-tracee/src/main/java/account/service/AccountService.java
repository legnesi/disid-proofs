package account.service;

import java.util.List;

import account.domain.Account;

/**
 * = Javadoc in Asciidoc
 * 
 * Sample comments in `Asciidoctor`.
 * 
 * @author eruiz
 */
public interface AccountService {

    /**
     * Finds the *Account* with the provided account number.
     * 
     * @param number The account number
     * @return The account
     * @throws AccountNotFoundException If no such account exists.
     */
    Account findOne(String number) throws AccountNotFoundException;

    /**
     * Return a listing of all *Account* for a given customer.
     * 
     * @param owner
     *            Name of the _owner_ of the accounts.
     * @return the account listing
     */
    List<Account> findAllAccounts(String owner);

    /**
     * Saves the given entity.
     * 
     * @param account
     */
    void save(Account account);

    /**
     * Creates a new account.
     * 
     * @param account
     * @return created account
     */
    Account create(Account account);
}
