package me.miguelbarrios.FinanceApp.user.repositories;

import me.miguelbarrios.FinanceApp.user.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByUsername(String username);
}
