# 1. OpenJDK 이미지를 기반으로 이미지를 생성합니다
FROM openjdk:17-jdk-slim

# 2. 애플리케이션 JAR 파일을 이미지에 복사합니다
COPY /build/libs/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar

# 3. 애플리케이션을 실행할 명령어 설정
CMD ["java", "-jar", "/app/demo-0.0.1-SNAPSHOT.jar"]

# 4. 컨테이너가 사용할 포트를 지정합니다
EXPOSE 5500
