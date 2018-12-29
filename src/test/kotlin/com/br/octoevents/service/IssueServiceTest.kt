package com.br.octoevents.service

import com.br.octoevents.model.Issue
import com.br.octoevents.repository.IssueHookRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import java.util.*

@RunWith(JUnit4::class)
class IssueServiceTest {

    @Mock
    lateinit var issueService:IssueService

    @Mock
    lateinit var hookRepository: IssueHookRepository


    @Before
    fun setUp(){
        issueService = Mockito.mock(IssueService::class.java)
        hookRepository = Mockito.mock(IssueHookRepository::class.java)
    }

    @Test
    fun errorOnSaveIssue(){
        issueService.hookRepository = hookRepository
        val issue = Issue(-1L,
                "url",
                "Title",
                5L,
                Date())
        Mockito.`when`(hookRepository.save(issue)).thenReturn(issue)
        Assert.assertEquals(false,issueService.save(issue))
    }

    @Test
    fun successOnSaveIssue(){
        issueService.hookRepository = hookRepository
        val issueSucess = Issue(1,
                "url2",
                "Title2",
                3L,
                Date())
        Mockito.`when`(hookRepository.save(issueSucess)).thenReturn(issueSucess)
        Assert.assertNotEquals(true, issueService.save(issueSucess))
    }

}