package com.br.octoevents.service

import com.br.octoevents.model.Hook
import com.br.octoevents.repository.WebHookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Service para gerenciamento de hook padrões do github
 * @author douglas.takara
 */
@Service
class WebHookService {

    @Autowired
    lateinit var repository: WebHookRepository

    fun save(webHook: Hook):Boolean =  repository.save(webHook).id > 0L

    fun listAll(): List<Hook> = repository.findAll()
}