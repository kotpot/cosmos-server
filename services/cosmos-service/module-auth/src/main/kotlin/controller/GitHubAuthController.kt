package org.kotpot.cosmos.auth.controller

import org.kotpot.cosmos.auth.model.GitHubStepInfo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.result.view.Rendering

@Controller
@RequestMapping("/auth/github")
class GitHubAuthController {
    /**
     * Provide the GitHub App auth step info belong current user.
     */
    @GetMapping("/step")
    @ResponseBody
    suspend fun step(): GitHubStepInfo = TODO()

    /**
     * GitHub redirect callback.
     *
     * Request user token using [code] and save with [state],
     *
     * The route will redirect to target page by auth result.
     *
     * @param code The code of user provided by GitHub
     * @param state Flag state of target user that created by [step] mapping
     */
    @GetMapping("/callback")
    suspend fun authCallback(
        @RequestParam code: String,
        @RequestParam state: String
    ): Rendering {
        TODO()
    }

    /**
     * Fetch GitHub token by [uid].
     *
     * @param uid which same with state
     */
    @PostMapping("/token")
    @ResponseBody
    suspend fun getAuthToken(uid: String): String = TODO()

}