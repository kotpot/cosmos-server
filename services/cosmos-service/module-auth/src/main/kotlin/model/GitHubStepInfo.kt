package org.kotpot.cosmos.auth.model


data class GitHubStepInfo(
    val clientId: String,
    val redirectUri: String,
    val state: String,
)