package com.fahim.githubcommitlist.model

data class CommitModel(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)