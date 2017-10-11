使用 Druid 数据库连接池：
	在 application.properties 中加入：spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
========================================================================================================================
使用 MyBatis：
	1.pom.xml加入相关mybatis配置后 默认使用mybatis
	2.在 application.properties 中加入：mybatis.mapper-locations=classpath:mapper/*.xml 用于映射到 xml文件
	3.dao类中 加入 @Mapper 注解 用于springboot自动扫描
========================================================================================================================	
Student 相关 展示了 级联操作 使用一个 学生ID 就能查出 对应课程的成绩
========================================================================================================================
com.boot.conf.ConfigSettings
模拟配置类：
	1.@PropertySource：用于 引入外部文件
	2.@ConfigurationProperties(prefix = "xxx")：说明 此文件内 由xxx开头的属性自动嵌入
	3.此类中 必须加入 getter和setter
========================================================================================================================
使用 flywaydb 数据库管理工具
	1.pom.xml:
		dependencies 加入：
			<dependency>
				<groupId>org.flywaydb</groupId>
				<artifactId>flyway-core</artifactId>
			</dependency>
			
		plugins加入：
			<plugin>
			    <groupId>org.flywaydb</groupId>
			    <artifactId>flyway-maven-plugin</artifactId>
			</plugin>
	2.在 resources/db/migration 中加入 VYYY__XXXXXX.sql (YYY:为数字；XXXXXX：随意；中间为两个下划线)
	3.在 application.properties 中加入：flyway.baselineOnMigrate=true
	4.执行启动类 启动时 可见 flyway 启动 在 mysql 中 自动创建 schema_version 表 用于记录 sql脚本的变化
========================================================================================================================			