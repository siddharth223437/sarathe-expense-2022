package com.sarathe.expense.service;

import com.sarathe.expense.models.RoleName;
import com.sarathe.expense.models.Roles;

public interface IRole {

    public void add(Roles role);
    public Roles findRoleByName(RoleName roleName);
}
