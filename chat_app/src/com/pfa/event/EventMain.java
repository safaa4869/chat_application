package com.pfa.event;

import com.pfa.model.Model_User_Account;

/**
 *
 * @author safae
 */
public interface EventMain {

    public void ShowLoading(boolean show);

    public void initChat();

    public void selectUser(Model_User_Account user);

    public void updateUser(Model_User_Account user);
}
