/**
 * @Author Rancho Lee
 * @Email iotcoder@gmail.com
 * @Date May 24, 2018 10:58:27 PM
 * @Description
 */
package site.iotor.hello.spring.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import site.iotor.hello.spring.model.PersistentLogins;

/**
 * @author Rancho
 */

@Repository("persistentTokenRepository")
@Transactional
public class PersistentTokenDaoImp implements PersistentTokenRepository {
    
    private final SessionFactory sessionFactory;

    public PersistentTokenDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.rememberme.PersistentTokenRepository#createNewToken(org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken)
     */
    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        // Auto-generated method stub
        PersistentLogins logins = new PersistentLogins();
        logins.setUsername(token.getUsername());
        logins.setSeries(token.getSeries());
        logins.setToken(token.getTokenValue());
        logins.setLastUsed(token.getDate());
        sessionFactory.getCurrentSession().save(logins);
    }

    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.rememberme.PersistentTokenRepository#updateToken(java.lang.String, java.lang.String, java.util.Date)
     */
    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        // Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        PersistentLogins logins=session.get(PersistentLogins.class, series);
        logins.setToken(tokenValue);
        logins.setLastUsed(lastUsed);
    }

    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.rememberme.PersistentTokenRepository#getTokenForSeries(java.lang.String)
     */
    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        // Auto-generated method stub
        PersistentLogins logins = sessionFactory.getCurrentSession()
                .get(PersistentLogins.class, seriesId);
          
          if (logins != null) {
            return new PersistentRememberMeToken(logins.getUsername(), 
                logins.getSeries(), logins.getToken(),logins.getLastUsed());
          }

          return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.rememberme.PersistentTokenRepository#removeUserTokens(java.lang.String)
     */
    @Override
    public void removeUserTokens(String username) {
        // Auto-generated method stub
        sessionFactory.getCurrentSession().createQuery("delete from PersistentLogins" 
                + " where username=:userName")
                .setParameter("userName", username).executeUpdate();
    }

}
