package com.kin.big_events.service;

import com.kin.big_events.pojo.User;

public interface UserService {
    //
    void register(String username, String password);

    //
    User findByUserName(String username);

    //
    void update(User user);

    //
    void updateAvatar(String avatarUrl);

    void updatePwd(String newPwd);
}
