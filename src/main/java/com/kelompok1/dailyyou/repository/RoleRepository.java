package com.kelompok1.dailyyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kelompok1.dailyyou.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
