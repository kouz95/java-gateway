package me.kouz.module.member.application;

import lombok.RequiredArgsConstructor;
import me.kouz.module.member.application.dto.MemberRequest;
import me.kouz.module.member.application.dto.MemberResponse;
import me.kouz.module.member.domain.model.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<MemberResponse> findAll() {
        return MemberResponse.listFrom(memberRepository.findAll());
    }

    @Transactional(readOnly = true)
    public MemberResponse findById(Long id) {
        return MemberResponse.from(memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("member not exist")));
    }

    @Transactional
    public MemberResponse save(MemberRequest request) {
        return MemberResponse.from(memberRepository.save(request.toEntity()));
    }
}
