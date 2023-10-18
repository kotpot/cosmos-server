package org.kotpot.cosmos.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccessTokenResponse(
    @SerialName("access_token") var accessToken: String? = null,
    @SerialName("scope") var scope: String? = null,
    @SerialName("token_type") var tokenType: String? = null,
    @SerialName("error") var error: String? = null,
    @SerialName("error_description") var errorDescription: String? = null
)