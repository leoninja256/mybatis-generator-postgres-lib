# mybatis-generator-postgres-lib
MyBatis Generator Library for PostgreSQL

## PostgresJavaTypeResolver

`PostgresJavaTypeResolver`を使用することで、  
PostgreSQLのtimestamp with time zone型をLocalDateTimeではなくOffsetDateTimeで生成します。

Usage

```xml
<generatorConfiguration>
  <context ...>
...
    <javaTypeResolver type="net.leoninja.mybatis.generator.postgreslib.PostgresJavaTypeResolver">
      <property name="useJSR310Types" value="true" />
    </javaTypeResolver>
...
```
