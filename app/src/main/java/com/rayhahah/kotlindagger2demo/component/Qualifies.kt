package com.rayhahah.kotlindagger2demo.component

import java.lang.annotation.Documented
import javax.inject.Qualifier


/* Name 限定符 */
@Qualifier
@Documented
@Retention(AnnotationRetention.RUNTIME)
annotation class NameQualifier



/* Name 限定符 */
@Qualifier
@Documented
@Retention(AnnotationRetention.RUNTIME)
annotation class AgeQualifier

