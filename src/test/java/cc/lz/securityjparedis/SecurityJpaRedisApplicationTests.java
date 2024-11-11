package cc.lz.securityjparedis;

import cc.lz.securityjparedis.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class SecurityJpaRedisApplicationTests {

    @Test
    void contextLoads() {
        List<UserEntity> list = new ArrayList<>();
        list.add(UserEntity.
                builder()
                .username("lee")
                .password("123")
                .build());
        list.add(UserEntity.
                builder()
                .username("lee1")
                .password("456")
                .build());
        list.add(UserEntity.
                builder()
                .username("lee2")
                .password("789")
                .build());
        list.add(UserEntity.
                builder()
                .username("lee3")
                .password("1135")
                .build());
        List<String> usernames = list.stream().map(UserEntity::getUsername).toList();
        System.out.println(usernames);
        List<Integer> passwords = list.stream()
                .map(UserEntity::getPassword)
                .filter(password -> password.contains("1"))
                .map(Integer::valueOf)
                .toList();
        System.out.println(passwords);
    }
}
