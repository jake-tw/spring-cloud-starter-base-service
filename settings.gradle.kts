rootProject.name = "spring-cloud-webstore"

// com.jake.webstore.common.{support for}
include("webstore-common")
include("webstore-common:webstore-domain")
include("webstore-common:webstore-redis-utils")

// com.jake.webstore.{service name}.api
include("webstore-api-interface")
include("webstore-api-interface:webstore-user-api")
include("webstore-api-interface:webstore-sso-api")

// com.jake.webstore.{service name}
include("webstore-service")
include("webstore-service:webstore-user")
include("webstore-service:webstore-sso")

// com.jake.webstore.cloud.{structure}
include("webstore-cloud")
include("webstore-cloud:webstore-cloud-base")