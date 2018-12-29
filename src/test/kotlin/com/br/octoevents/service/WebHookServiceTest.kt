package com.br.octoevents.service

import com.br.octoevents.model.Hook
import com.br.octoevents.repository.WebHookRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito

@RunWith(JUnit4::class)
class WebHookServiceTest {

    @Mock
    lateinit var webHookService:WebHookService

    @Mock
    lateinit var webHookRepository: WebHookRepository


    @Before
    fun setUp(){
        webHookService = Mockito.mock(WebHookService::class.java)
        webHookRepository = Mockito.mock(WebHookRepository::class.java)
    }

    @Test
    fun errorOnSaveIssue(){
        val hook = Hook(-1L,
                "url",
                arrayListOf("Title"),
                true)
        Mockito.`when`(webHookRepository.save(hook)).thenReturn(hook)
        Assert.assertEquals(false,webHookService.save(hook))
    }

    @Test
    fun successOnSaveIssue(){
        val hook = Hook(5L,
                "url",
                arrayListOf("Title"),
                true)
        Mockito.`when`(webHookRepository.save(hook)).thenReturn(hook)
        Assert.assertNotEquals(true,webHookService.save(hook))
    }
}