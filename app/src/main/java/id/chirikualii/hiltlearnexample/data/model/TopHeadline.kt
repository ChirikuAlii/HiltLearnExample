package id.chirikualii.hiltlearnexample.data.model

data class TopHeadline(
        val articles: List<Article> = listOf(),
        val status: String = "",
        val totalResults: Int = 0
)