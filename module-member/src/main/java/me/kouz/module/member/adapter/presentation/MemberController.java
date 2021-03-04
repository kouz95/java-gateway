package me.kouz.module.member.adapter.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/members")
@Controller
public class MemberController {
    @GetMapping
    public ResponseEntity<String> findAll() {
        return ResponseEntity.ok("all members");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findOne(@PathVariable String id) {
        return ResponseEntity.ok("member id: " + id);
    }
}
