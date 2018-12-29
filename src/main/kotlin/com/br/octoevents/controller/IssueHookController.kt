package com.br.octoevents.controller

import com.br.octoevents.service.IssueService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * End-point para o listagem de eventos relacionados à casos
 * @author douglas.takara
 */
@RestController
@RequestMapping("/issues")
class IssueHookController {

    @Autowired
    lateinit var service: IssueService

    /**
     * Lista eventos relacionados à casos de acordo com número do caso inserido
     * @param idIssue = número do caso
     */
    @GetMapping("/{id}/events")
    fun getEvents(@PathVariable("id") idIssue:String): ResponseEntity<Any>{
        val issues = service.findById(idIssue.toLong())
        return ResponseEntity(issues, HttpStatus.OK)
    }
}