package cn.yugj.test.nacos.provider;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * security boot 2.0 配置方式
 * @author yugj
 */
@Configuration
public class ActuatorBasicSecurityConfigurer extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/sys/**").hasRole("sys")
                .anyRequest().permitAll()
                .and().httpBasic()
                .and().csrf().disable();
    }

}
