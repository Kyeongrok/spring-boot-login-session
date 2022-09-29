package com.bbs;

import com.bbs.adapter.outgoing.entity.Member;
import com.bbs.adapter.outgoing.repository.MemberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BbsApplication {

    final MemberRepository memberRepository;

    public BbsApplication(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BbsApplication.class, args);
    }

    @PostConstruct
    public void init() {

        Member member = new Member();
        member.setLoginId("user2");
        member.setPassword("password");
        member.setName("Kyeongrok");

        memberRepository.save(member);

    }

}
