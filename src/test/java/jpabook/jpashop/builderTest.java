package jpabook.jpashop;

import lombok.Builder;
import lombok.Getter;
import org.junit.jupiter.api.Test;

public class builderTest {

    @Getter
    static class TestVo {
        private Long id;
        private Long age;
        private String userName;

        @Builder
        public TestVo(Long id, Long age, String userName) {
            this.id = id;
            this.age = age;
            this.userName = userName;
        }
    }

    @Test
    public void testBuilder() {

        TestVo vo1 = TestVo.builder()
                .id(1L)
                .age(33L)
                .userName("조용현")
                .build();

        System.out.println("vo1 = " + vo1.getId() + vo1.getAge() + vo1.getUserName());

        System.out.println("==================");

        TestVo vo2 = TestVo.builder()
                .id(2L)
                .age(32L)
                .build();

        System.out.println("vo2 = " + vo2.getId() + vo2.getAge() + vo2.getUserName());

    }
}
