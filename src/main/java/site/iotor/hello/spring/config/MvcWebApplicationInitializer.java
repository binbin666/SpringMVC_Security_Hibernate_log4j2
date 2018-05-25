/**
 * @Author Rancho Lee
 * @Email iotcoder@gmail.com
 * @Date May 21, 2018 8:58:31 PM
 * @Description
 */
package site.iotor.hello.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Rancho
 *
 */
public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.support.
     * AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses
     * ()
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Auto-generated method stub
        return new Class[] { AppConfig.class, WebSecurityConfig.class };
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.support.
     * AbstractAnnotationConfigDispatcherServletInitializer#
     * getServletConfigClasses()
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Auto-generated method stub
        return new Class[] { WebConfig.class };
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.support.
     * AbstractDispatcherServletInitializer#getServletMappings()
     */
    @Override
    protected String[] getServletMappings() {
        // TODO Auto-generated method stub
        return new String[] { "/" };
    }

}
