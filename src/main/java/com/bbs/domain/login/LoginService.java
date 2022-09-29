package com.bbs.domain.login;

import com.bbs.adapter.outgoing.entity.Member;
import com.bbs.adapter.outgoing.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password) {

        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }



}
