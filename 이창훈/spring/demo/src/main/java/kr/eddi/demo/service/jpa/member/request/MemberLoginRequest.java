package kr.eddi.demo.service.jpa.member.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class MemberLoginRequest {
    private final String email;
    private final String password;
}
