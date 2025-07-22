package org.seasheperd.ghostnetfishing.frontend.geisternetz;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Status;
import org.seasheperd.ghostnetfishing.endpoint.geisternetz.GeisternetzEndpointModel;
import org.seasheperd.ghostnetfishing.endpoint.geisternetz.GeisternetzEndpointService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@Controller
public class GeisternetzDetailController {
    private final GeisternetzEndpointService geisternetzService;


    @GetMapping("/geisternetz/{id}")
    public String showGeisternetzDetailPage(@PathVariable long id,
                                            Model model,
                                            HttpSession session,
                                            RedirectAttributes redirectAttributes) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        GeisternetzEndpointModel geisternetz = geisternetzService.findById(id);

        if (geisternetz == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Geisternetz nicht gefunden.");
            return "redirect:/geisternetz";
        } else {
            model.addAttribute("geisternetz", geisternetz);
            return "geisternetz-detail";
        }
    }

    @PostMapping("/geisternetz/zuweisen")
    public String weiseGeisternetzZu(@RequestParam Long geisternetzId,
                                     HttpSession session,
                                     RedirectAttributes redirectAttributes) {

        long userId = (Long) (session.getAttribute("userId"));

        geisternetzService.updateGeisternetzUserId(geisternetzId, userId);
        redirectAttributes.addFlashAttribute("successMessage", "Das Geisternetz wurde erfolgreich zugewiesen.");

        return "redirect:/geisternetz/" + geisternetzId;
    }

    @PostMapping("/geisternetz/status")
    public String changeStatus(@RequestParam Long geisternetzId,
                               @RequestParam Status neuerStatus,
                               RedirectAttributes redirectAttributes) {

        geisternetzService.updateGeisternetzStatus(geisternetzId, neuerStatus);

        redirectAttributes.addFlashAttribute("successMessage", "Der Status des Geisternetz wurde erfolgreich geändert.");

        return "redirect:/geisternetz/" + geisternetzId;
    }
}
