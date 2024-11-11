/**
 * @author leezan
 * @Data 2024/11/1 21:30
 */
package cc.lz.securityjparedis.service.impl;

import cc.lz.securityjparedis.dao.UserRepository;
import cc.lz.securityjparedis.entity.LoginUser;
import cc.lz.securityjparedis.entity.UserEntity;
import cc.lz.securityjparedis.service.UserService;
import cc.lz.securityjparedis.utils.JwtUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Resource
    AuthenticationManager authenticationManager;

    @Resource
    private JwtUtil jwtUtil;

    @Override
    public void createUser(UserEntity userEntity) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(encodePassword);
        userRepository.save(userEntity);
    }


    @Override
    public String login(LoginUser loginUser) {
        UserEntity user = userRepository.findUserEntitiesByUsername(loginUser.getUsername());
        if (user == null) {
            return null;
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (bCryptPasswordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            return jwtUtil.generateToken(loginUser);
        }
        return null;
    }
}
