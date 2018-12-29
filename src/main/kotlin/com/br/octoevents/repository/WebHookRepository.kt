package com.br.octoevents.repository

import com.br.octoevents.model.Hook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repositorio para gerenciamento de hook padrões do github
 * @author douglas.takara
 */
@Repository
interface WebHookRepository : JpaRepository<Hook, Long>