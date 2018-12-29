package com.br.octoevents.controller

import com.br.octoevents.model.PayloadIssue
import com.br.octoevents.model.PayloadWebHook
import com.br.octoevents.service.IssueService
import com.br.octoevents.service.WebHookService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * End-point para o gerenciamento/listener de hooks do github
 * @author douglas.takara
 */
@RestController
@RequestMapping("/events")
class WebHookController  {

    val EVENT_TYPE_ISSUE = "issues"
    val EVENT_TYPE_PING = "ping"
    val MSG_SUCCESS = "Evento salvo com sucesso"
    val ERROR_SAVE_WEBHOOK = "Erro ao salvar WebHook"

    /** Service para gerenciamento de eventos relacionados à casos */
    @Autowired
    lateinit var issueService: IssueService

    /** Service para gerencimanto de eventos genéricos */
    @Autowired
    lateinit var webHookService: WebHookService

    /**
     * Lista todos os eventos genéricos
     */
    @GetMapping
    fun listAll():ResponseEntity<Any>{
        return ResponseEntity(webHookService.listAll(), HttpStatus.OK)
    }

    /**
     * Listener para eventos do github
     * Registra de acordo com o tipo do evento
     * @param gitHubEvent - flag para verificação do tipo do evento
     * @param rawPayload - dados do evento
     */
    @PostMapping()
    @RequestMapping(value="/", consumes = arrayOf(MediaType.APPLICATION_FORM_URLENCODED_VALUE),
        produces = arrayOf(MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE))
    fun webHooks(@RequestHeader(value="X-Github-Event") gitHubEvent: String,
                 @RequestParam(value = "payload") rawPayload: String): ResponseEntity<Any> {

        if(EVENT_TYPE_ISSUE.equals(gitHubEvent)){
            val playLoad = Gson().fromJson(rawPayload, PayloadIssue::class.java)
            playLoad.issue.let {
                val isSaved = issueService.save(it!!)
                if(isSaved){
                    return ResponseEntity(MSG_SUCCESS,HttpStatus.OK)
                }
            }

        }else {
            if(EVENT_TYPE_PING.equals(gitHubEvent)){
                val playLoad = Gson().fromJson(rawPayload, PayloadWebHook::class.java)

                playLoad.hook.let {
                    val isSaved = webHookService.save(it!!)
                    if(isSaved){
                        return ResponseEntity(MSG_SUCCESS,HttpStatus.OK)
                    }
                }
            }
        }

        return ResponseEntity(ERROR_SAVE_WEBHOOK,HttpStatus.INTERNAL_SERVER_ERROR)
    }
}