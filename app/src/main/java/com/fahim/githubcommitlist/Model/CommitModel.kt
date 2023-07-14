package com.fahim.githubcommitlist.Model

data class CommitModel(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)