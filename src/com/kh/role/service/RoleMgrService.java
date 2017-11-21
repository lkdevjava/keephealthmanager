package com.kh.role.service;

import java.util.Set;

public interface RoleMgrService {

    public Set<String> queryRoleInfosByUserId(int userId);
    
}
