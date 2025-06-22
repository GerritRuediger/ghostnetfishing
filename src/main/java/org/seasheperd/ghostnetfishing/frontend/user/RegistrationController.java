package org.seasheperd.ghostnetfishing.frontend.user;

import lombok.RequiredArgsConstructor;
import org.seasheperd.ghostnetfishing.endpoint.user.UserEndpointModel;
import org.seasheperd.ghostnetfishing.endpoint.user.UserEndpointService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final UserEndpointService userEndpointService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEndpointModel());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(
            @ModelAttribute("user") UserEndpointModel userDto,
            Model model) {

        System.out.println("Registrierung: " + userDto.getTelefonnr());
        try {
            userEndpointService.registerUser(userDto);
            return "login";
        } catch (Exception ex) {
            return "register";
        }
    }
}
