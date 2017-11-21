package com.kh.permission.service;

import java.util.Set;

public interface PermissionMgrService {

    public Set<String> queryRoleRelPermissionsInfosByRoles(Set<String> roles);

}
