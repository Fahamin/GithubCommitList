package com.fahim.githubcommitlist.model

data class Commit(
    val author: AuthorX,
    val comment_count: Int,
    val committer: Committer,
    val message: String,
    val tree: Tree,
    val url: String
)