package com.br.octoevents.model

import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Beans para gerencimanto de dados sobre hook de casos que serão consumidos do github
 * @author douglas.takara
 */
data class PayloadIssue(val action:String,
                        val issue:Issue) : Serializable {

}

@Entity
data class Issue (@Id val id:Long,
                  @Column val url:String,
                  @Column val title:String,
                  @Column val number:Long,
                  @Column val created_at: Date) : Serializable{
}
