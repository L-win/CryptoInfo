package com.elvina.cryptoinfo.domain.model

import com.elvina.cryptoinfo.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val is_active: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>,

    val started_at: String?,
    val logo: String?,
    val open_source: Boolean?,
    val hash: String?,
    val proof: String?,
    val organization: String?

)
