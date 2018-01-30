# Dagger2笔记

## Inject
- 标记在构造方法上 ：一会在`Activity`中当系统需要对VpAdater的实例进行注入的时候，会自动调用具有`@Inject`注解的构造方法
- 标记在需要依赖的变量上 ：以让`Dagger2`为其提供依赖


## Module
前面`@Inject`的实例化对象中，参数应该怎么传递，就是用`@Module`

- 使用了`@Module`注解的类专门提供依赖，谁需要依赖，都可以从这里获取

### Provider
注解方法，该注解只可以在@Module中使用，使用了该注解的方法在需要提供依赖时被调用



## Component
>一个接口，`@Inject`和`@Module`之间的桥梁，也称作注入器

我的理解是统一的组织者调度这
如
`ApplicationComponent`
`ActivityComponent`


- `fun inject(obj:目标类)`：从目标类开始查找`@Inject`注解，生成依赖注入的代码；
- `fun xxx():Obj`：生成`Obj`实例，供其它组件使用（如果`Obj`本身还包含其它依赖注入，也会自动生成对应实例）

`ApplicationComponent`和`ActivityComponent`提供的是一种服务能力，供业务组件使用，服务能力的来源就是对应Module的工厂方法。

## Scope
> 定义作用于注解的注解

通过我们的代码层次，大家可以看到，Scope到底有什么用？

- 管理`Component`层次结构，明确地显示`Component`的作用范围；
- 管理`Component`与`Module`之间的匹配关系，提供代码的可读性；
- `Scope`就是用来看的，并没有依赖注入的实质功能，为了大家的代码更加优雅，建议使用`Scope`明确作用域
- 使用`Dependencies`的`Component`之间不能有相同 `@Scope` 注解的；使用`@SubComponent`




## Qualifier
情景：需要提供相同的类型，如何区分应该使用`Module`中的哪一个`provider`来提供呢？


这个时候就可以使用`Qualifier`来标注
`@Name`：本质就是一个`Qualifier`，使用方式下面一并介绍


使用如下：
1. 定义限定符

```

/**
 * Java中
 */
Documented
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeQualifier{
}



/*
 * Kotlin中使用
 *Age 限定符
 */
@Qualifier
@Documented
@Retention(AnnotationRetention.RUNTIME)
annotation class AgeQualifier
```

2. `Module`中的`provider`使用

```


    @AgeQualifier
    @Provides
    fun providerAgeStr(): String {
        return "age"
    }

    @Named("id")
    @Provides
    fun providerId(): Int {
        return 1
    }

```


3. 对象或者构造方法中使用

```
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


或者在对像中使用
//    @field:[AgeQualifier]
    @AgeQualifier
    @Inject
    lateinit var mPhone: Phone

```