package com.property.repository;

import com.property.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    Optional<Profile> findByEmail(String email);
    boolean existsByEmail(String email);

    @Query("SELECT p FROM Profile p LEFT JOIN FETCH p.portfolios WHERE p.id = :id")
    Optional<Profile> findByIdWithPortfolios(@Param("id") UUID id);
} 