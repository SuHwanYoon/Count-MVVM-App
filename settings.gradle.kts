//settings.gradle.kts 파일은 Gradle 빌드 시스템에서 프로젝트의 설정을 정의하는 파일입니다. 이 파일의 주요 역할은 다음과 같습니다:
//프로젝트 이름 설정: rootProject.name을 사용하여 루트 프로젝트의 이름을 설정합니다.
//서브프로젝트 포함: include를 사용하여 빌드에 포함될 서브프로젝트를 정의합니다.
//저장소 설정: pluginManagement와 dependencyResolutionManagement 블록을 사용하여 플러그인과 의존성을 다운로드할 저장소를 정의합니다.
//레포지토리 모드 설정: repositoriesMode.set을 사용하여 프로젝트 레벨에서 저장소를 추가할 수 있는지 여부를 설정합니다.

pluginManagement {dependencyResolutionManagement {
    // 프로젝트 레포지토리를 사용하지 않도록 설정합니다.
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    // 플러그인을 다운로드할 저장소를 정의
    repositories {
        // Google의 Maven 저장소를 사용합니다.
        google()
        // Maven Central 저장소를 사용합니다.
        mavenCentral()
    }
}
    // 플러그인 관리 섹션으로, 플러그인을 다운로드할 저장소를 정의합니다.
    repositories {
        // Google의 Maven 저장소를 사용합니다.
        google()
        // Maven Central 저장소를 사용합니다.
        mavenCentral()
        // Gradle 플러그인 포털을 사용합니다.
        gradlePluginPortal()
    }
}

rootProject.name = "CouterMVVM"
include(":app")

//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//    }
//}
