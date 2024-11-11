/**
 * @author leezan
 * @Data 2024/11/1 21:29
 */
package cc.lz.securityjparedis.dao;

import cc.lz.securityjparedis.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<Long> {
    UserEntity findUserEntitiesByUsername(String username);
}
