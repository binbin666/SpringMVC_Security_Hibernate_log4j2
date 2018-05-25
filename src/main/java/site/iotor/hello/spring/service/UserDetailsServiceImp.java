/**
 * @Author Rancho Lee
 * @Email iotcoder@gmail.com
 * @Date May 21, 2018 9:10:08 PM
 * @Description
 */
package site.iotor.hello.spring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.iotor.hello.spring.dao.UserDetailsDao;
import site.iotor.hello.spring.model.User;

/**
 * @author Rancho
 */

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    Logger logger = LogManager.getLogger(this.getClass().getName());

    @Autowired
    private UserDetailsDao userDetailsDao;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetailsService#
     * loadUserByUsername(java.lang.String)
     */
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Auto-generated method stub
        User user = userDetailsDao.findUserByUsername(username);
        UserBuilder builder = null;
        if (user != null) {

            logger.info("loadUserByUsername>userModelToString:" + user.toString());
            
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.disabled(!user.isEnabled());
            builder.password(user.getPassword());
            String[] authorities = user.getAuthorities().stream().map(a -> a.getAuthority()).toArray(String[]::new);

            builder.authorities(authorities);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

}
