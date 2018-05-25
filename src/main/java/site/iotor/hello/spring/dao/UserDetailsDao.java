/**
 * @Author Rancho Lee
 * @Email iotcoder@gmail.com
 * @Date May 21, 2018 9:06:57 PM
 * @Description
 */
package site.iotor.hello.spring.dao;

import site.iotor.hello.spring.model.User;

/**
 * @author Rancho
 *
 */
public interface UserDetailsDao {

    User findUserByUsername(String username);
}
