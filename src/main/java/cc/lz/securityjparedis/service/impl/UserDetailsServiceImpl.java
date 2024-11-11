/**
 * @author leezan
 * @Data 2024/11/1 21:37
 */
package cc.lz.securityjparedis.service.impl;

import cc.lz.securityjparedis.dao.UserRepository;
import cc.lz.securityjparedis.entity.LoginUser;
import cc.lz.securityjparedis.entity.UserEntity;
import jakarta.annotation.Resource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserRepository userRepository;
    @Override
    @Cacheable(value = {"cache"}, key = "#username")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserEntitiesByUsername(username);
        return LoginUser
                .builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .build();
    }
}
