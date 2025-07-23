package org.sheasepherd.ghostnetfishing.frontend.geisternetz;

import lombok.RequiredArgsConstructor;
import org.sheasepherd.ghostnetfishing.endpoint.geisternetz.GeisternetzEndpointModel;
import org.sheasepherd.ghostnetfishing.endpoint.geisternetz.GeisternetzEndpointService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class GeisternetzNewController {
    private final GeisternetzEndpointService geisternetzService;

    @GetMapping("/geisternetz/new")
    public String showNewGeisternetzForm(Model model) {
        model.addAttribute("geisternetz", new GeisternetzEndpointModel());
        return "geisternetz-new";
    }

    @PostMapping("/geisternetz/new")
    public String registerNewGeisternetz(@ModelAttribute("geisternetz") GeisternetzEndpointModel geisternetz,
                                         RedirectAttributes redirectAttributes) {
        geisternetzService.submitNewGeisternetz(geisternetz.getStandort(), geisternetz.getGroesse());
        redirectAttributes.addFlashAttribute("successMessage", "Geisternetz wurde erfolgreich gespeichert.");

        return "redirect:/geisternetz/new";
    }
}
