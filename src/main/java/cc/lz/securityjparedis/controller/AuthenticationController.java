/**
 * @author leezan
 * @Data 2024/11/1 17:48
 */
package cc.lz.securityjparedis.controller;

import cc.lz.securityjparedis.entity.LoginUser;
import cc.lz.securityjparedis.entity.UserEntity;
import cc.lz.securityjparedis.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody @Validated LoginUser loginUser) {
        return userService.login(loginUser);
    }

    @PutMapping("/register")
    public String register(@RequestBody @Validated UserEntity userEntity) {
        userService.createUser(userEntity);
        return "register ok";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
