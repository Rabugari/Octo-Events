package com.br.octoevents.model

import com.br.octoevents.converter.StringListConverter
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Beans para gerencimanto de dados sobre hook genéricos que serão consumidos do github
 * @author douglas.takara
 */
data class PayloadWebHook(val zen:String?,
                          val hook_id:Long?,
                          val hook:Hook?): Serializable {
}

@Entity
data class Hook(@Id val id:Long,
                @Column val name:String,
                @Column @Convert(converter = StringListConverter::class)val events: List<String>,
                @Column val active: Boolean=false):Serializable {
}
