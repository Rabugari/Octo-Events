package com.br.octoevents.service

import com.br.octoevents.model.Issue
import com.br.octoevents.repository.IssueHookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Serviço para gerenciamento de hook relacionados a casos refente a projeto configurado no Github
 * @author douglas.takara
 */
@Service
class IssueService {

    @Autowired
    lateinit var hookRepository: IssueHookRepository

    /**
     * Seleciona casos, dado um número
     * @param number - numero do caso
     */
    fun findById(number: Long): List<Issue> = hookRepository.findAllByNumber(number)

    fun save(it: Issue): Boolean {
        val idt = hookRepository.save(it).id
        var b = idt.compareTo(0) > 0
        return b
    }
}