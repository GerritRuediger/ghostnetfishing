package org.seasheperd.ghostnetfishing.frontend.geisternetz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeisternetzPrivateOverview {

    @GetMapping("/personal")
    public String showPrivateOverview() {

    }
}
