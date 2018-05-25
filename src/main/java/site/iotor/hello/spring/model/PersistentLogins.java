/**
 * @Author Rancho Lee
 * @Email iotcoder@gmail.com
 * @Date May 24, 2018 10:54:56 PM
 * @Description
 */
package site.iotor.hello.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rancho
 */

@Getter
@Setter
@Entity
@Table(name = "LOGINS_PERSISTENT")
public class PersistentLogins {
    @Id
    @Column(name = "SERIES")
    private String series;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "TOKEN", nullable = false)
    private String token;

    @Column(name = "LAST_USED", nullable = false)
    private Date lastUsed;
}
