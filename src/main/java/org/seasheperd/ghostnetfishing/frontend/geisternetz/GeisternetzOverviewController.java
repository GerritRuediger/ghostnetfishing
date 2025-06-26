package org.seasheperd.ghostnetfishing.frontend.geisternetz;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.seasheperd.ghostnetfishing.endpoint.geisternetz.GeisternetzEndpointModel;
import org.seasheperd.ghostnetfishing.endpoint.geisternetz.GeisternetzEndpointService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class GeisternetzOverviewController {
    private final GeisternetzEndpointService geisternetzService;

    @GetMapping("/geisternetz")
    public String showGeisternetzUebersicht(Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        model.addAttribute("geisternetze", geisternetzService.findAllGemeldetGeisternetze());
        return "geisternetz-uebersicht";
    }

    @PostMapping("/geisternetz")
    public String registerNewGeisternetz(@ModelAttribute("geisternetz") GeisternetzEndpointModel geisternetz,
                                         Model model,
                                         RedirectAttributes redirectAttributes) {
        geisternetzService.submitNewGeisternetz(geisternetz.getStandort(), geisternetz.getGroesse());
        redirectAttributes.addFlashAttribute("successMessage", "Geisternetz wurde erfolgreich gespeichert.");

        return "redirect:/geisternetz/new";
    }

}
