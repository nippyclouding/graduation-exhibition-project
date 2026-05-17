package server.TripToN.concern.controller;

import org.springframework.web.bind.annotation.*;
import server.TripToN.concern.dto.*;
import server.TripToN.concern.service.ConcernService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
@RequestMapping("/concern")
public class ConcernController {

    private final ConcernService concernService;

    @PostMapping
    public String saveConcern(@Valid @ModelAttribute ConcernRequestDto dto) {
        concernService.saveConcern(dto);
        return "redirect:/concern";
    }

    @GetMapping
    public String getConcerns(Model model) {
        model.addAttribute("concernResponseDto", concernService.getConcerns());
        return "result";
    }
}
