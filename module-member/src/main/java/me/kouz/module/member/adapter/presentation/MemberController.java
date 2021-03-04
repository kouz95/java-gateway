package me.kouz.module.member.adapter.presentation;

import lombok.RequiredArgsConstructor;
import me.kouz.module.member.application.MemberService;
import me.kouz.module.member.application.dto.MemberRequest;
import me.kouz.module.member.application.dto.MemberResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/members")
@Controller
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> findAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> save(@RequestBody MemberRequest request) {
        return ResponseEntity.created(URI.create("/api/members/" + memberService.save(request).getId())).build();
    }
}
