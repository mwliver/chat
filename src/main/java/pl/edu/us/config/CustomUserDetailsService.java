package pl.edu.us.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.us.persistance.client.dao.User;
import pl.edu.us.persistance.client.dao.UserDao;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Copyright (C) Coderion sp. z o.o
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserDao userDao;

    @Autowired
    public CustomUserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Iterable<User> all = userDao.findAll();
        while (all.iterator().hasNext()) {
            User next = all.iterator().next();
            if (next.getLogin().equals(username)) {
                return new UserRepositoryUserDetails(next);
            }
        }

        throw new UsernameNotFoundException(String.format(
                "User %s does not exist!", "test"));
    }

    public final static class UserRepositoryUserDetails implements UserDetails {
        private static final long serialVersionUID = 1L;

        public User user;

        private UserRepositoryUserDetails(User user) {
            this.user = user;
        }

        @Override
        public String getUsername() {
            return user.getLogin();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            // TODO Auto-generated method stub
            GrantedAuthority auth = new GrantedAuthorityImpl("ROLE_USER");

            ArrayList<GrantedAuthority> arr = new ArrayList<GrantedAuthority>();
            arr.add(auth);
            return arr;

        }
    }

}
