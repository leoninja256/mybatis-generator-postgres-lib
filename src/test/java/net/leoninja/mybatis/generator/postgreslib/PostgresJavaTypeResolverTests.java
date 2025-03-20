package net.leoninja.mybatis.generator.postgreslib;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;

public class PostgresJavaTypeResolverTests {
	@Test
	public void calculateTimestampType_useJSR310Types_true() {
		PostgresJavaTypeResolver target = new PostgresJavaTypeResolver();

		Properties props = new Properties();
		props.setProperty("useJSR310Types", "true");
		target.addConfigurationProperties(props);

		IntrospectedColumn introspectedColumn = new IntrospectedColumn();
		FullyQualifiedJavaType fullyQualifiedJavaType = new FullyQualifiedJavaType(Date.class.getName());

		// 実行
		FullyQualifiedJavaType result = target.calculateTimestampType(introspectedColumn, fullyQualifiedJavaType);

		// 検証
		assertNotNull(result);
		assertEquals(java.time.OffsetDateTime.class.getName(), result.getFullyQualifiedName());
	}

	@Test
	public void calculateTimestampType_useJSR310Types_false() {
		PostgresJavaTypeResolver target = new PostgresJavaTypeResolver();

		Properties props = new Properties();
		props.setProperty("useJSR310Types", "false");
		target.addConfigurationProperties(props);

		IntrospectedColumn introspectedColumn = new IntrospectedColumn();
		FullyQualifiedJavaType fullyQualifiedJavaType = new FullyQualifiedJavaType(Date.class.getName());

		// 実行
		FullyQualifiedJavaType result = target.calculateTimestampType(introspectedColumn, fullyQualifiedJavaType);

		// 検証
		assertSame(fullyQualifiedJavaType, result);
	}
}
