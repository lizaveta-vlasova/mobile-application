package com.mobileapplication.service.ServiceImpl;

import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.ClientRoleEnum;
import com.mobileapplication.service.ClientService;
import com.mobileapplication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@ComponentScan
public class ClientDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       /* Client client = loginService.login(email);
        if(client == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                client.getEmail(), client.getPassword(),
                true, true,
                true, true,
                getGrantedAuthorities(client));
    }

    private Set<GrantedAuthority> getGrantedAuthorities(Client client) {
        Set<GrantedAuthority> authorities = new HashSet<>();

        authorities.add(new SimpleGrantedAuthority(client.getRole().getRoleName()));

        return authorities;
    }*/
        return null;
    }
}

