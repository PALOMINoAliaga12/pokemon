package com.palomino.luis.pokemon

data class PokemonListResponse(
    val name: String,
    val url: String,
    val results: List<PokemonResponse>
)