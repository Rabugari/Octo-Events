package com.br.octoevents.controller

import com.br.octoevents.model.Issue
import com.br.octoevents.model.PayloadIssue
import com.br.octoevents.repository.IssueHookRepository
import com.br.octoevents.repository.WebHookRepository
import com.br.octoevents.service.IssueService
import com.br.octoevents.service.WebHookService
import com.google.gson.Gson
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.*


@RunWith(JUnit4::class)
@SpringBootTest
class WebHookControllerTest {

    @Mock
    lateinit var webHookController: WebHookController

    @Mock
    lateinit var issueService: IssueService
    @Mock
    lateinit var webHookService: WebHookService

    @Mock
    lateinit var issueHookRepository: IssueHookRepository

    @Mock
    lateinit var webHookRepository: WebHookRepository


    val EVENT_TYPE_ISSUE = "issues"
    val EVENT_TYPE_PING = "ping"
    val MSG_SUCCESS = "Evento salvo com sucesso"
    val ERROR_SAVE_WEBHOOK = "Erro ao salvar WebHook"

    @Before
    fun setUp(){
        issueService = Mockito.mock(IssueService::class.java)
        issueHookRepository = Mockito.mock(IssueHookRepository::class.java)
        issueService.hookRepository = issueHookRepository

        webHookService = Mockito.mock(WebHookService::class.java)
        webHookRepository = Mockito.mock(WebHookRepository::class.java)
        webHookService.repository = webHookRepository

        webHookController= WebHookController()
        webHookController.issueService=issueService
        webHookController.webHookService=webHookService
    }

    @Test
    fun testList(){
        Mockito.`when`(webHookService.listAll()).thenReturn(arrayListOf())
        Mockito.`when`(issueHookRepository.findAll()).thenReturn(arrayListOf())
        Assert.assertEquals(ResponseEntity(webHookService.listAll(), HttpStatus.OK), webHookController.listAll())
    }

//   @Test
//    fun testEventEqualsIssue(){
//        var value:String="{action:opened,issue:{id:1}}"
//        val responseEntity = webHookController.webHooks(EVENT_TYPE_ISSUE, value)
//        val payloadIssue = PayloadIssue("action", Issue(1L, "url", "title", 5L, Date()))
//       Mockito.`when`(Gson().fromJson(value, PayloadIssue::class.java)).thenReturn(payloadIssue)
//       Mockito.`when`(issueService.save(payloadIssue.issue)).thenReturn(true)
//       Assert.assertEquals(ResponseEntity(MSG_SUCCESS, HttpStatus.OK), responseEntity)
//    }
}