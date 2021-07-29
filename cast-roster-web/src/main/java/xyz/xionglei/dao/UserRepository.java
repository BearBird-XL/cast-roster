package xyz.xionglei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.xionglei.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
}
