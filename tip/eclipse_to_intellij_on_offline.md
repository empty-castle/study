# 오프라인 환경에서 이클립스 프로젝트를 인텔리제이로 실행 시키기

## 프로젝트 열기

1. File > Project from Existing Sources
2. 프로젝트가 받아져 있는 폴더 선택해서 진행
3. Create project from existing sources로 프로젝트 생성에 필요한 파일 자동 검색 기능 활용하며 마무리

## maven

1. File > Settings > Build, Execution, Deployment > Build Tools > Maven
2. 옵션
	- Work offline 켜기
	- Use settings from .mvn/maven.config 끄기
3. 설정
	- User settings file: settings.xml 설정, 로컬 레포지토리 주소 참조용
	- Local repository: 라이브러리 모아둔 폴더 설정
4. (옵션) 오래된 프로젝트, Maven 관리가 제대로 안 되어 있는 프로젝트
  1. File > Project Structure
	2. Libraries에 누락된 라이브러리 수동 추가
	3. 추가한 라이브러리 Modules에 추가되었는지 확인
5. (욥션) Spring 프로젝트인 경우, 톰캣을 사용하는 경우
	1. 톰캣 실행 시 Artidacts 추가가 필요(File > Project Structure)
	2. :war의 Ourput Layout 탭에서 하단 Show content of elements 켜서 폴더 구조 확인
	3. WEB-INF/lib 아래에 라이브러리 전부 들어가야 함
6. 빌드 후 실행 확인


## gradle

1. File > Settings > Build, Execution, Deployment > Build Tools > Gradle
2. 설정
	1) Gradle user home: gradle home 경로 수정
		- home에는 wrapper, jdks, native, daemon, caches, notifications 폴더가 구성되어 있음
	2) Gradle Projects 아래 각각의 모듈들의 설정 변경
		- Build and Run/Build and run using 옵션을 Intellij IDEA로 변경
			- 아래 설정이 제대로 동작하기 위해 변경
		- Gradle/Distribution을 Local installation 옵션으로 변경 후 경로 수정
			- 해당 경로 아래에는 bin, init.d, lib 폴더가 들어가 있음.
3. 빌드 후 실행 확인

## Live Templates

1. 이클립스에서 구성된 설정 확인
	- Window > Preferences > Java > Code Style > Code Templates
		- Comments가 주석, 그 중 Types가 Class 단위
2. 인텔리제이에 이클립스 설정과 마찬가지로 세팅
	- File > Settings > Editor > Live Templates > Java
	- Live templates 생성
		- Applicable in Java는 comment로 설정하면 주석 안에서만 자동완성 가능
		- '$변수명$'로 변수 선언 가능, 선언 이후 Edit Variables로 변수 설정