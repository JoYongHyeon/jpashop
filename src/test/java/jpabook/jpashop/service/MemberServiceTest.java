package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
//    @Rollback(false) // 잘 등록됐는지 확인하기 위해서 (@Transactional : 기본적으로 rollback 해버림
    public void 회원가입() throws Exception {
        // given => 이런게 주어졌을때
        Member member = new Member();
        member.setName("kim");

        // when => 이걸 실행하면
        Long saveId = memberService.join(member);

        // then => 이게 나와야 돼 (member 가  memberRepository.findOne(saveId) 찾은 값과 같냐?
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class) // 이런 예외가 발생하면 된다.
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        // when
        memberService.join(member1);
        memberService.join(member2); // 예외가 발생해야 한다.!!!

        // then
        fail("예외가 발생해야 한다.");
    }
}