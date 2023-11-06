rootProject.name = "spring-cloud-webstore"

include("webstore-api-interface")
include("webstore-api-interface:webstore-user-api")

include("webstore-service")
include("webstore-service:webstore-user")

include("webstore-common")
include("webstore-common:webstore-utils")
