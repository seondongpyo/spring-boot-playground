package io.github.seondongpyo.thymeleaf.web.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.role = :role")
    List<Member> findAllByRole(@Param("role") Role role);
}
