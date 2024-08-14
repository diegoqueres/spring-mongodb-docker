package net.diegoqueres.mongodocker

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/olympic-sports")
class OlympicSportController(
    private val service: OlympicSportService
) {

    @PostMapping
    fun save(@RequestBody olympicSport: OlympicSport): ResponseEntity<OlympicSport> =
        ResponseEntity.ok(service.save(olympicSport))

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<OlympicSport> =
        service.findById(id)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())

    @GetMapping
    fun findAll(): ResponseEntity<List<OlympicSport>> =
        ResponseEntity.ok(service.findAll())

}