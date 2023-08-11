package com.elvina.cryptoinfo.data.remote.dto

import com.elvina.cryptoinfo.domain.model.CoinDetail

data class CoinDetailDto(
    val description: String,
    val development_status: String,
    val first_data_at: String,
    val hardware_wallet: Boolean,
    val hash_algorithm: String,
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val last_data_at: String,
    val logo: String,
    val message: String,
    val name: String,
    val open_source: Boolean,
    val org_structure: String,
    val proof_type: String,
    val rank: Int,
    val started_at: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        is_active = is_active,
        tags = tags.map { it.name },
        team = team,

        started_at = started_at,
        logo = logo,
        open_source = open_source,
        hash = hash_algorithm,
        proof = proof_type,
        organization = org_structure

    )
}