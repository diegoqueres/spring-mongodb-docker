package net.diegoqueres.mongodocker

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "olympicSports")
data class OlympicSport (
    @Id val id: String? = null,
    val name: String,
    val category: String,
    val male: Boolean,
    val female: Boolean,
    val yearIntroduced: Int,
    val countryOfOrigin: String,
    val disciplines: List<Discipline>
)

data class Discipline(
    val name: String,
    val basicRules: String,
    val numberOfParticipants: Int
)