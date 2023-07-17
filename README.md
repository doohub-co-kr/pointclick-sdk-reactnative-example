
ReactNative를 위한 PointClick SDK 연동 예제

# pointclick-sdk-reactnative-example
- 이 프로젝트는 Pointclick SDK ReactNative 연동 예제 프로젝트입니다.
- ReactNative SDK 예제는 Android 4.1(Jelly Bean, API Level 16) 이상 기기와 JDK 11 이상에서 동작합니다.
- 최신 버전의 Pointclick SDK 사용을 권장합니다.
- 최신 버전의 Android Studio와 Visual Studio Code 사용을 권장합니다. Eclipse에 대한 기술 지원은 하지 않습니다.

Installation
----

1. 프로젝트 루트 경로에 명령어 실행
    ```npm install```

2. 프로젝트 레벨의 build.gradle 파일에 accessKey와 secretkey 입력
    - ReactNative를 위한 SDK 연동방법 문서에 기록된 accessKey와 secretKey를 입력합니다.
    ```
        ...
        allprojects {
            repositories {
                google()
                mavenCentral()
                ...
                // PointClick SDK Repository
                maven {
                    url "s3://repo.pointclick.co.kr/releases"
                    credentials(AwsCredentials) {
                        accessKey "제공된 문서에 기록된 accessKey를 사용"
                        secretKey "제공된 문서에 기록된 secretKey를 사용"
                    }
                }
                // Maven Remote Repo에서 PointClick aar파일을 가져올 때 세팅 끝
                ...
            }
        }        
        ...
    ```

Run
----
1. Settings(윈도우는 Preferences) > Build, Executeion, Deployment > Build Tools > Gradle > Gradle JDK를 11 선택 > Apply 및 OK 
2. 프로젝트루트/android/app/src/main/assets 폴더 확인 후 없으면 생성
3. 프로젝트루트/android 폴더에서 ./gradlew clean 실행
4. 프로젝트루트에서 다음 명령어 실행
    ```
    react-native bundle --platform android --dev false --entry-file index.js --bundle-output ./android/app/src/main/assets/index.android.bundle --assets-dest ./android/app/src/main/res
    ```
5. 안드로이드 스튜디오 > Settings > Reload all from disk 실행 
6. 안드로이드 스튜디오 > Settings > Sync project
7. 안드로이드 스튜디오 > Build > Clean & rebuild
8. npm run android 실행 또는 안드로이드 스튜디오에서 실행 버튼 클릭

js파일 수정 시 적용방법
----
1. 프로젝트루트/android/app/src/main/assets 폴더 아래 index.android.bundle 파일 삭제
2. 프로젝트루트/android 폴더에서 ./gradlew clean 실행
3. 프로젝트루트에서 다음 명령어 실행
    ```
    react-native bundle --platform android --dev false --entry-file index.js --bundle-output ./android/app/src/main/assets/index.android.bundle --assets-dest ./android/app/src/main/res
    ```
4. npm run android 실행 또는 안드로이드 스튜디오에서 실행 버튼 클릭