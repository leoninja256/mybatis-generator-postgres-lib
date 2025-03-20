package net.leoninja.mybatis.generator.postgreslib;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

public class PostgresJavaTypeResolver extends JavaTypeResolverDefaultImpl {
	@Override
	protected FullyQualifiedJavaType calculateTimestampType(IntrospectedColumn column,
			FullyQualifiedJavaType defaultType) {
		FullyQualifiedJavaType answer;

		if (useJSR310Types) {
			answer = new FullyQualifiedJavaType("java.time.OffsetDateTime");
		} else {
			answer = defaultType;
		}

		return answer;
	}

}
