/**
 * @author leezan
 * @Data 2024/11/1 21:30
 */
package cc.lz.securityjparedis.service;

import cc.lz.securityjparedis.entity.LoginUser;
import cc.lz.securityjparedis.entity.UserEntity;

public interface UserService {

    void createUser(UserEntity userEntity);

    String login(LoginUser loginUser);
}
