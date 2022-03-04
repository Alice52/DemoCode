## validation

1. `@Email` and `@Min` etc, it will not validate null.

   - if use `@Email` to validate `null` value, it can go though the validation.

2. use `@Validated` to decorate class, and **annotated in interface**

   - turn on the parameter verification function for the methods in this class[对本类中的方法开启参数验证功能]
   - then use validation annotation in method parameter, **and remove annotation in impl class**

3. @Valid

   - controller 入参 @Valid 校验不通过时会 throw BindException
   - controller call service @Valid 校验不通过时会 throw ConstraintViolation

   ```java
   // Marks a property, method parameter or method return type for validation cascading
   // This behavior is applied recursively.
   @Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE })
   @Retention(RUNTIME)
   @Documented
   public @interface Valid {
   }
   ```

4. @Validated

   - @Validated 校验不通过时,MethodArgumentNotValidException 会将结果放到 BindingResult 中, 且每个参数校验结果都是单独的 BindingResult 对象
   - `@Validated 加在类上[bean 除外]会将标注的类包装为切面, 从而让类中的方法调用时, 支持 Java 的校验`
     - 放在 controller 类上, 且需要 @Valid 才能校验对象生效
     - 获取到改代理对象就可以实现 service 之间的调用校验: 由于代理对象底层是通过接口的相关参数进行创建的
     - `因此获取该代理对象时需要使用接口的类名, 即使 @Service 注解使用在实现类上`
     - `且必须有借口才能进行参数校验`

   ```java
   @Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
   @Retention(RetentionPolicy.RUNTIME)
   @Documented
   public @interface Validated {

       // Specify one or more validation groups to apply to the validation step
       // kicked off by this annotation.
       Class<?>[] value() default {};
   }
   ```

## conlusion

1. @NotEmpty

   - CharSequence
   - Collection
   - Map
   - Array

2. @NotBlank

   - CharSequence

3. 接口和实现类的返回值上都有注解

   - 都起作用

4. 校验级联属性

   - 对象嵌套必须使用 @Valid: `private @Valid PkPaperDTO paperDTO;`

5. List 对象校验 & List 字段校验

   - List 字段校验: `@Size(message = "xx", min = 1)`
   - List 中的对象校验: `List<@Valid PkSubjectDTO> subjectDTOS`
   - @Valid 没有分组功能, 可以自定义注解: `extends ConstraintValidator`

6. `一个 service 中的不同方法之间相互调用的 validation`

   - 必须是有接口
   - 必须是 public 且非 final 非 static 的方法
   - 先获取到 service proxy 对象
   - proxy.method()

7. `坑`
   - **注解一般不会处理 null 的情况, 可以通过校验**

## issue

1. javax.validation.UnexpectedTypeException: HV000030: No validator could be found for constraint

   - @NotEmpty 用在集合类上面
   - @NotBlank 用在 String 上面
   - @NotNull 用在基本类型上
   - 在枚举类上不要加非空注解

2. 单个方法参数注解的工作原理

   ```java
   @GetMapping
   public void query() {
       aopService.validate(null);
   }

   public void validate(@NotNull String name) {
      LOG.info("add first method");
   }
   ```

   - 代理
   - isvalid 方法
   - isvalid == false, throw exception

3. aop

   - 还是局限于 Public 的方法, 且需要有接口
   - 可以考虑使用 reflect 自己去获取私有方法, 之后进行相关参数的校验
   - [`aop.bean.validation` is aop implement](https://www.abtosoftware.com/blog/form-validation-using-aspect-oriented-programming-aop-in-spring-framework): // TODO:

## reference

1. [exposeProxy](https://blog.csdn.net/weixin_40910372/article/details/103565970)
2. [BeanCurrentlyInCreationException](https://blog.csdn.net/f641385712/article/details/92797058)
3. [bug：exposeProxy](https://blog.csdn.net/f641385712/article/details/93475774)
4. issue: https://github.com/Alice52/project/issues/24
5. issue: https://github.com/Alice52/java-ocean/issues/242
