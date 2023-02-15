package ra.model.serviceIpm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.ERole;
import ra.model.entity.Roles;
import ra.model.service.RoleService;
import ra.repository.RoleRepository;

import java.util.Optional;


@Service
public class RoleServiceIpm implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Roles> findByRoleName(ERole roleName) {

        return roleRepository.findByRoleName(roleName);
    }

}
