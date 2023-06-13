package com.Reboot.Minty.member.repository;

import com.Reboot.Minty.member.constant.Role;
import com.Reboot.Minty.member.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    int countByEmail(String email);
    List<User> findByRole(Role role);

    List<User> findByIdContaining(String keyword);
    List<User> findByNickNameContaining(String keyword);
    List<User> findByNameContaining(String keyword);
}
