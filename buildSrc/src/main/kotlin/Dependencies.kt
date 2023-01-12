/**
 * buildSrc와 included build
 * gradle에서는 root 디렉토리 아래에 buildSrc 라는 디렉토리가 있으면
 * 해당 디렉토리는 included build로 다루어 진다.
 * included build로 다루어지면 gradle에서는 자동적으로 해당 디렉토리의 내용을
 * 컴파일 및 테스트하고 build script에서 참조할 수 있도록 classpath에 넣어두게 된다.
 * 따라서 사용하는 사람은 이를 직접 호출해서 가져와 사용할 수 있다는 의미이다.
 */

object Dependencies {
    object Libs {
        val KOTLIN = listOf(
            "org.jetbrains.kotlin:kotlin-reflect",
            "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
        )
    }
}