package org.seasheperd.ghostnetfishing.frontend.geisternetz;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
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
    public String showNewGeisternetzForm(@PathVariable Long id, Model model) {
        if (id == null) {
            throw new IllegalArgumentException("id is null");
        }

        GeisternetzEndpointModel geisternetz = geisternetzService.findById(id);

        if (geisternetz == null) {
            throw new IllegalArgumentException("geisternetz not found");
        } else {
            model.addAttribute("geisternetz", geisternetz);
            System.out.println("userId: " + geisternetz.getUserId());
        }
        return "geisternetz-detail";
    }

    @PostMapping("/geisternetz/zuweisen")
    public String weiseGeisternetzZu(@RequestParam Long geisternetzId,
                                     HttpSession session,
                                     RedirectAttributes redirectAttributes) {

        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Sie müssen angemeldet sein.");
            return "redirect:/login";
        }

        geisternetzService.updateGeisternetzUserId(geisternetzId, userId);

        return "redirect:/geisternetz/" + geisternetzId;
    }
}
