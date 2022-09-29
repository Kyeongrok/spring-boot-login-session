package com.bbs.adapter.outgoing.repository;

import com.bbs.adapter.outgoing.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByLoginId(String id);
}
