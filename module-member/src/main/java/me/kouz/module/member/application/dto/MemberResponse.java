package me.kouz.module.member.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.kouz.module.member.domain.model.Member;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class MemberResponse {
    private final Long id;
    private final String name;

    private MemberResponse() {
        this(null, null);
    }

    public static MemberResponse from(Member member) {
        return new MemberResponse(member.getId(), member.getName());
    }

    public static List<MemberResponse> listFrom(List<Member> members) {
        return members.stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }
}
