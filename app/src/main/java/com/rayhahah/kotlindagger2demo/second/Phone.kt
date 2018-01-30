package com.rayhahah.kotlindagger2demo.second

import com.rayhahah.kotlindagger2demo.component.AgeQualifier
import com.rayhahah.kotlindagger2demo.component.NameQualifier
import com.rayhahah.kotlindagger2demo.log
import javax.inject.Inject
import javax.inject.Named

class Phone
@Inject constructor(
        @NameQualifier val name: String,
        @AgeQualifier val age: String,
        @Named("id") val id: Int) {
    init {
        id.log()
        name.log()
        age.log()
    }
}