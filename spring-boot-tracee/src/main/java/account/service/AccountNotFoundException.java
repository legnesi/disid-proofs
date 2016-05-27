package account.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * = Javadoc in Asciidoc
 * 
 * Sample comments in `Asciidoctor`.
 *
 * @author eruiz
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Account") // 404
public class AccountNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3891534644498426670L;

    public AccountNotFoundException(String accountId) {
        super("No such account with id: " + accountId);
    }
}

