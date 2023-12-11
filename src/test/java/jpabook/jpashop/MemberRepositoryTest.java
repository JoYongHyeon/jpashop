//package jpabook.jpashop;
//
//
//
//import jpabook.jpashop.domain.Member;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.assertj.core.api.Assertions.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MemberRepositoryTest {
//
//    @Autowired
//    MemberRepository memberRepository;
//
//    @Test
//    @Transactional // 테스트 케이스에 트랜잭션이 있다면 끝나고 난 뒤 롤백해버림
//    @Rollback(false)
//    public void testMember() {
//
//        Member member = new Member();
//        member.setUsername("memberA");
//
//        Long savedId = memberRepository.save(member);
//        Member findMember = memberRepository.find(savedId);
//
//        assertThat(findMember.getId()).isEqualTo(member.getId());
//        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//        assertThat(findMember).isEqualTo(member);
//        System.out.println("findMember == member: " + (findMember == member));
//        /*
//            쿼리 파라미터 로그 남기기
//            스프링 부트 3.0 이상을 사용하면 라이브러리 버전을 1.9.0 이상을 사용해야 한다.
//            implementation 'com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.9.0'
//         */
//    } }