package org.seasheperd.ghostnetfishing.frontend.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.seasheperd.ghostnetfishing.endpoint.user.UserEndpointService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserEndpointService userEndpointService;

    @GetMapping("/login")
    public String showLogin(HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) {
            model.addAttribute("telefonnr");
            model.addAttribute("password");
            return "login";
        } else {
            return "redirect:/geisternetz";
        }
    }

    @PostMapping("/login")
    public String processLogin(
            @ModelAttribute("telefonnr") String telefonnr,
            @ModelAttribute("password") String password,
            HttpSession httpSession,
            Model model) {


        Long userId = userEndpointService.verifyLogin(telefonnr, password);
        if (userId == null) {
            model.addAttribute("errorMessage", "Login fehlgeschlagen.");
            return "login";
        } else {
            httpSession.setAttribute("userId", userId);
            return "redirect:/geisternetz";
        }
    }

    @GetMapping("/logout")
    public String processLogout(HttpSession httpSession) {
        httpSession.removeAttribute("userId");
        return "redirect:/";
    }
}
