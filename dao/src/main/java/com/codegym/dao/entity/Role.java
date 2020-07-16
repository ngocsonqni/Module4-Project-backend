package com.codegym.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="role")
public class Role {
//    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "roles")
    private Set<Account> accounts;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setUsers(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Role() {
    }
}