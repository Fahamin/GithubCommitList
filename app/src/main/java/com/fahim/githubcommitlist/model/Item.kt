package com.fahim.githubcommitlist.model

data class Item(
    val author: Author,
    val comments_url: String,
    val commit: Commit,
    val committer: CommitterX,
    val html_url: String,
    val node_id: String,
    val parents: List<Parent>,
    val repository: Repository,
    val score: Double,
    val sha: String,
    val url: String
)