package ra.model.serviceIpm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Users;
import ra.model.service.UserService;
import ra.repository.UserRepository;

@Service
public class UserServiceIpm  implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Users findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Users saveOrUpdate(Users users) {
        return userRepository.save(users);
    }
}
