package project;

import java.io.Console;
import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 * Authentication and Authorization of usernames and passwords.
 * <p><ul>
 * <li>Authentication: Identifying the entity that is currently running the code
 * <li>Authorization: Once authenticated, ensure that this entity has the required access control rights or permissions to execute sensitive code
 */
public class ConsoleCallbackHandler  implements CallbackHandler {

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

        Console console = System.console();
        for(Callback callback : callbacks) {
            if(callback instanceof NameCallback) {
                NameCallback nameCallback = (NameCallback) callback;
                nameCallback.setName(console.readLine(nameCallback.getPrompt()));
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback passwordCallback = (PasswordCallback) callback;
                passwordCallback.setPassword(console.readPassword(passwordCallback.getPrompt()));
            } else {
                throw new UnsupportedCallbackException(callback);
            }
        }
        
    }

    
    
}
