package me.kouz.module.member.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.kouz.module.member.domain.model.Member;

@Getter
@RequiredArgsConstructor
public class MemberRequest {
    private final String name;

    private MemberRequest() {
        this(null);
    }

    public Member toEntity() {
        return new Member(null, name);
    }
}
