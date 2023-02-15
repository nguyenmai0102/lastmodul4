package ra.model.service;


import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.entity.ERole;
import ra.model.entity.Roles;

import java.util.Optional;

public interface RoleService {
    Optional<Roles> findByRoleName(ERole roleName);
}
