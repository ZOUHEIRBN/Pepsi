package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.example.demo.Enum.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@JsonIgnoreProperties({"authorities"})
public class HR implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String username;
    @Column
    @JsonIgnore
    String password;
    
    @ElementCollection(targetClass = Role.class)
    @JoinTable(name = "roles")
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    List<Role> roles;


    @Column
    boolean accountNonExpired = true;
    @Column
    boolean enabled = true;
    @Column
    boolean accountNonLocked = true;
    @Column
    boolean credentialsNonExpired = true;


    @OneToMany(mappedBy = "user")
    List<Notification> notifications;

    public HR() {
        this.username = "";
        this.password = "";
        this.accountNonExpired = true;
        this.enabled = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;

    }

    public HR(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> SGAuth = new ArrayList<SimpleGrantedAuthority>();
        for(Role r: roles){
            SGAuth.add(new SimpleGrantedAuthority(r.toString()));
        }
        return SGAuth;
        // return List.of(new SimpleGrantedAuthority(roles.toString()));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
    
}
