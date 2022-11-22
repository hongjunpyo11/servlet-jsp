package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id;
    private String username;
    private int age;

    public Member() {
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

/**
 * 회원 관리 웹 애플리케이션 요구사항
 *
 * 회원 정보
 * 이름: username
 * 나이: age
 * 기능 요구사항
 * 회원 저장
 * 회원 목록 조회
 */
