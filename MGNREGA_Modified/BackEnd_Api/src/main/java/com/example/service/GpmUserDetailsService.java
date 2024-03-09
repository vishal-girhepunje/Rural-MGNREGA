package com.example.service;

import com.example.model.GPM;
import com.example.repository.GpmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GpmUserDetailsService implements UserDetailsService {

    @Autowired
    private GpmRepository gpmRepository;

    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<GPM> opt = gpmRepository.findByEmail(username);
        if(opt.isPresent()){
            GPM gpm = opt.get();
            List<GrantedAuthority> authorityList = new ArrayList<>();
            SimpleGrantedAuthority sga = new SimpleGrantedAuthority(gpm.getRole());
            authorityList.add(sga);
            return new User(gpm.getEmail(), gpm.getPassword(), authorityList);
        }
        else throw new BadCredentialsException("User Details not found with this username: " + username);
    }
}
