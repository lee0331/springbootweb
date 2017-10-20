使用 Druid 数据库连接池：
	在 application.properties 中加入：spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
<br /><br />
使用 MyBatis：
	1.pom.xml加入相关mybatis配置后 默认使用mybatis
	2.在 application.properties 中加入：mybatis.mapper-locations=classpath:mapper/*.xml 用于映射到 xml文件
	3.dao类中 加入 @Mapper 注解 用于springboot自动扫描
<br /><br />	
Student 相关 展示了 级联操作 使用一个 学生ID 就能查出 对应课程的成绩
<br /><br />
com.boot.conf.ConfigSettings
模拟配置类：
	1.@PropertySource：用于 引入外部文件
	2.@ConfigurationProperties(prefix = "xxx")：说明 此文件内 由xxx开头的属性自动嵌入
	3.此类中 必须加入 getter和setter
<br /><br />
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
<br /><br />
使用 websocket
	广播形式：
		1.pom.xml 加入：
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-websocket</artifactId>
			</dependency>
		2.创建
			com.boot.domain.wisely.WiselyMessage 浏览器给服务端发送消息
			com.boot.domain.wisely.WiselyResponse 服务端给浏览器发送消息
			com.boot.conf.WebSocketConfig 注册节点 配置消息代理
			com.boot.conf.WebConfig 默认访问 controller 直接跳转到 html
		3.创建 ws.html
		4.创建 com.boot.controller.IndexController
			public WiselyResponse say(WiselyMessage wiselyMessage)
				使用 
				@MessageMapping("/welcome")
				@SendTo("/topic/getResponse")
<br /><br />
使用JMS
	pom.xml 加入：
		<!-- JMS -->
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-jms</artifactId>
		</dependency>
	使用activeMQ：
		1.pom.xml加入：
			<!-- activeMQ -->
			<dependency>
			    <groupId>org.apache.activemq</groupId>
			    <artifactId>activemq-client</artifactId>
			    <version>5.15.0</version>
			</dependency>
		2.设置代理地址
			spring.activemq.broker-url=tcp://localhost:61616
		3.实现 MessageCreator：
			com.boot.msg.MsgJMS
		4.设置 JmsTemplate 监听 com.boot.msg.MsgJMS.Receiver.receiverMessage_jms(String message)
		5.设置 JmsTemplate 发送目的地 com.boot.controller.public @ResponseBody String jmsSend()
		6.访问：http://localhost:9091/jmsSend
	使用rabbitMQ：
		1.pom.xml加入：
			<!-- rabbitMQ -->
			<dependency>
			    <groupId>org.springframework.amqp</groupId>
			    <artifactId>spring-rabbit</artifactId>
			</dependency>
		2.设置 rabbitTemplate 监听目的地 com.boot.msg.MsgJMS.receiverMessage_rabbit(String message) 
		3.定义目的地（队列）
			com.boot.msg.MsgJMS
				@Bean
				public Queue getQueue() {
					return new Queue("rabbit-queue");
				}
		4.设置rabbitTemplate 发送目的地 com.boot.controller.public @ResponseBody String rabbitSend()
		5.访问：http://localhost:9091/rabbitSend		
		com.boot.controller
			@RequestMapping("/jmsSend") JMS 使用 activeMQ 发送消息 并接受  com.boot.msg.MsgJMS.Receiver
			@RequestMapping("/rabbitSend") JMS 使用 rabbitMQ 发送消息 并接受 com.boot.msg.MsgJMS
<br /><br />
spring-boot 实现热部署的方式：
	pom.xml 加入：
		<!-- 实现热部署 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
		</dependency>
<br /><br />
