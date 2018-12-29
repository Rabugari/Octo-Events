package com.br.octoevents

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Aplicação de reação da eventos, de acordo com gerenciamento no github
 * @author douglas.takara
 */
@SpringBootApplication
class OctoEventsApplication

fun main(args: Array<String>) {
    runApplication<OctoEventsApplication>(*args)
}
