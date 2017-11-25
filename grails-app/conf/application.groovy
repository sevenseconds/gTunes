import org.apache.tomcat.jdbc.pool.interceptor.ConnectionState

environments {
    production {
        dataSource {
            driverClassName = "org.postgresql.Driver"
            dialect = org.hibernate.dialect.PostgreSQL94Dialect
            uri = new URI(System.env.DATABASE_URL ?: "postgres://test:test@localhost/test")
            url = "jdbc:postgresql://$uri.host:$uri.port$uri.path"
            username = uri.userInfo.split(":")[0]
            password = uri.userInfo.split(":")[1]

            properties {
                jmxEnabled = true
                initialSize = 5
                maxActive = 50
                minIdle = 5
                maxIdle = 25
                maxWait = 10000
                maxAge = 600000
                timeBetweenEvictionRunsMillis = 5000
                minEvictableIdleTimeMillis = 60000
                validationQuery = 'SELECT 1'
                validationQueryTimeout = 3
                validationInterval = 15000
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = false
                jdbcInterceptors = ConnectionState
                defaultTransactionIsolation = 2 // TRANSACTION_READ_COMMITTED
            }
        }
    }
}