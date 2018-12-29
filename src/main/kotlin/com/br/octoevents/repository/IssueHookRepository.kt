package com.br.octoevents.repository

import com.br.octoevents.model.Issue
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repositório para gerenciamento de hook relacionados a casos refente a projeto configurado no Github
 * @author douglas.takara
 */
@Repository
interface IssueHookRepository : JpaRepository<Issue, Long>{

    fun findAllByNumber(number: Long): List<Issue>
}