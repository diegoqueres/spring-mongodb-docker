package net.diegoqueres.mongodocker

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface OlympicSportRepository : MongoRepository<OlympicSport, String>