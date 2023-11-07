rootProject.name = "spring-cloud-webstore"

// com.jake.webstore.common
include("webstore-common")
include("webstore-common:webstore-common-api")
include("webstore-common:webstore-redis-utils")

// com.jake.webstore.api
include("webstore-api-interface")
include("webstore-api-interface:webstore-user-api")

// com.jake.webstore
include("webstore-service")
include("webstore-service:webstore-user")