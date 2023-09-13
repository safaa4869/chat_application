
package com.pfa.event;

import com.pfa.model.Model_Login;
import com.pfa.model.Model_Register;

/**
 *
 * @author safae
 */
public interface EventLogin {
    public void login(Model_Login data);
    public void register(Model_Register data, EventMessage message);
    public void goRegister();
    public void goLogin();
    
}
