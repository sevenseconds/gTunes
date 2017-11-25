environments {
    production {
        dataSource {
            driverClassName = "org.postgresql.Driver"
            dialect = org.hibernate.dialect.PostgreSQL94Dialect
            uri = new URI(System.env.DATABASE_URL ?: "postgres://test:test@localhost/test")
            url = "jdbc:postgresql://$uri.host:$uri.port$uri.path"
            username = uri.userInfo.split(":")[0]
            password = uri.userInfo.split(":")[1]
        }
    }
}