package server.TripToN.admin;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import server.TripToN.admin.dto.AdminLoginRequestDto;
import server.TripToN.admin.dto.TotalCountResponseDto;
import server.TripToN.global.util.Const;

@RequiredArgsConstructor
@RequestMapping("/admin-console")
@Controller
public class AdminController {
    private final AdminService adminService;
    private final AdminProperties adminProperties;

    @GetMapping
    public String admin(Model model) {
        model.addAttribute("adminLoginRequestDto", new AdminLoginRequestDto());
        return "admin_login";
    }


    @PostMapping
    public String admin(@Valid @ModelAttribute AdminLoginRequestDto dto,
                        Model model,
                        HttpSession session) {
        boolean authenticated =
                        adminProperties.getAdminLoginId().equals(dto.getAdminLoginId())
                        && adminProperties.getAdminPassword().equals(dto.getAdminLoginPassword());

        if (!authenticated) {
            model.addAttribute("loginError", "관리자 ID 또는 비밀번호가 올바르지 않습니다.");
            return "admin_login";
        }

        session.setAttribute(Const.ADMIN_SESSION_KEY, true);
        return "admin";
    }


    @GetMapping("/totalConcernCount")
    public ResponseEntity<TotalCountResponseDto> getTotalCount() {
        return ResponseEntity.ok(adminService.getTotalCount());
    }

    @GetMapping("/concerns")
    public ResponseEntity<?> getConcerns(@RequestParam(defaultValue = "0") int page) {
        return ResponseEntity.ok(adminService.getConcerns(page));
    }
}
