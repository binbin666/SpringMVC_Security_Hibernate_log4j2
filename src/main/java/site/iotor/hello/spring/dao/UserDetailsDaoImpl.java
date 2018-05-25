/**
 * @Author Rancho Lee
 * @Email iotcoder@gmail.com
 * @Date May 21, 2018 9:07:45 PM
 * @Description
 */
package site.iotor.hello.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.iotor.hello.spring.model.User;


/**
 * @author Rancho
 */

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

//    Logger logger = LogManager.getLogger(this.getClass().getName());
    
    @Autowired
    private SessionFactory sessionFactory;

    /* (non-Javadoc)
     * @see com.boraji.tutorial.spring.dao.UserDetailsDao#findUserByUsername(java.lang.String)
     */
    @Override
    public User findUserByUsername(String username) {
        // Auto-generated method stub
        return sessionFactory.getCurrentSession().get(User.class, username);
    }

}
