package net.diegoqueres.mongodocker

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class OlympicSportService(
    private val repository: OlympicSportRepository
) {

    @Transactional
    fun save(olympicSport: OlympicSport): OlympicSport = repository.save(olympicSport)

    fun findById(id: String): Optional<OlympicSport> = repository.findById(id)

    fun findAll(): List<OlympicSport> = repository.findAll()

}