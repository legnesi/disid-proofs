package account.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import account.domain.Account;

/**
 * = Javadoc in Asciidoc
 * 
 * Sample comments in `Asciidoctor`.
 * 
 * @author eruiz
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Value("${dummy.type}")
    private String dummyType;

    /**
     * {@inheritDoc}
     * 
     * .Asciidoclet demo
     * [source,java]
     * --
     * public class Asciidoclet extends Doclet {
     *     private final Asciidoctor asciidoctor = Asciidoctor.Factory.create();
     *
     *     @SuppressWarnings("UnusedDeclaration")
     *     public static boolean start(RootDoc rootDoc) {
     *         new Asciidoclet().render(rootDoc);
     *         return Standard.start(rootDoc);
     *     }
     * }
     * --
     * 
     * Dummy method for testing purposes.
     * 
     * @param number The account number. Set 0000 to get an {@link AccountNotFoundException} 
     */
    @Override
    public Account findOne(String number) throws AccountNotFoundException {
        // dummy method
        if(number.equals("0000")) {
            throw new AccountNotFoundException("0000");
        }
        Account account = new Account(1, number);
        account.setType(getDummyType());
        account.setCreditCardNumber("1111 1111 1111 1111");

        LOG.info("New Account: ".concat(account.toString()));

        return account;
    }

    @Override
    public void save(Account account) {
        // dummy method
    }

    @Override
    public Account create(Account account) {
        account.setId(new Integer(1));
        return account;
    }

    @Override
    public List<Account> findAllAccounts(String owner) {
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account(1, "1111"));
        return accounts;
    }

    public String getDummyType() {
        return dummyType;
    }

    public void setDummyType(String dummyType) {
        this.dummyType = dummyType;
    }

}
