# Letscareer C Tech

## Server
<img src="https://img.shields.io/badge/java-007396?style=flat-square&logo=OpenJDK&logoColor=white"> <img src="https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white">
<img src="https://img.shields.io/badge/springboot-6DB33F?style=flat-square&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat-square&logo=Spring Security&logoColor=white">
<img src="https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=JUnit5&logoColor=white">
<img src="https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=Hibernate&logoColor=white">
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white">
<img src="https://img.shields.io/badge/Redis-DC382D?style=flat-square&logo=Redis&logoColor=white"> 
<img src="https://img.shields.io/badge/nginx-%23009639.svg?style=flat-square&logo=nginx&logoColor=white">
<img src="https://img.shields.io/badge/GitHub Actions-2088FF?style=flat-square&logo=GitHub Actions&logoColor=white">
<img src="https://img.shields.io/badge/Amazon%20EC2-FF9900?style=flat-square&logo=Amazon%20EC2&logoColor=white">
<img src="https://img.shields.io/badge/Amazon%20S3-569A31?style=flat-square&logo=Amazon%20S3&logoColor=white">


## Client
<img src="https://img.shields.io/badge/React-61DAFB?style=flat-square&logo=React&logoColor=black"/> <img src="https://img.shields.io/badge/Typescript-3178C6?style=flat-square&logo=Typescript&logoColor=white"/> <img src="https://img.shields.io/badge/Tailwind CSS-06B6D4?style=flat-square&logo=Tailwind CSS&logoColor=white"/>
<img src="https://img.shields.io/badge/Vercel-000000?style=flat-square&logo=Vercel&logoColor=white"/>

## Collaboration Tool
<img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white"/> <img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/>

## 1. 시스템 아키텍쳐
### 📄요구사항

![_letscareer drawio](https://github.com/user-attachments/assets/b6fda7e3-f39e-4477-99de-3a7c2ed4a613)

1. 성능 최적화
2. 외부공격대음
   - Spring Security를 사용해 기본적인 보안 설정(CSRF, Form Login) 방지
   - 퍼블릭 서브넷과 프라이빗 서브넷을 구분하여 외부에서 접근할 수 있는 서비스와 그렇지 않은 서비스를 구분.
     - RDS의 경우 프라이빗 서브넷에 위치시켜 외부 접속을 막음
   - Route53과 Nginx , Certbot을 사용해 HTTPS 적용
  

## 2. ERD
![letscareer_erd](https://github.com/user-attachments/assets/1cb569cd-1514-40aa-aefc-38d92c5498c5)

## 3. 사용 스택
| 사용 기술                   | 도입 이유                                                                                                                                                                                       |
|-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Github Actions          | - 지속적인 통합/지속적인 배포 (CI/CD) 구축을 통해 효율적이고 일관된 배포 및 테스트 프로세스를 구현하고자 함.</br> - 수동으로 배포 및 테스트를 진행하다보니 효율성이 떨어짐</br> - GitHub Actions vs Jenkins</br>⇒ 간편한 설정과 GitHub 통합을 중시하여 GitHub Actions로 결정함 |
| Redis                   | - 조회 성능 향상을 위한 캐시 저장소로 활용</br> ⇒ key-value 인메모리 저장소로 조회가 빠름.</br>                                                                                                                        |                                                                                                
| MySQL                   | 관계형 데이터베이스로서의 데이터 저장 및 관리에 사용                                                                                                                                                               |
| S3                      | 이미지 파일을 저장해 서버 부하를 줄임.                                                                                                                                                                      |
| NGINX                   | 리버스 프록시를 활용한 Https 적용                                                                                                                                                                       |
| Route 53                | 도메인 관리 및 트래픽 라우팅에 사용하여 서비스의 가용성과 성능을 향상시키고, 서비스 배포 및 관리를 용이                                                                                                                                 |
| EC2                     | 서버 호스팅 및 관리에 활용하여 애플리케이션의 확장성과 유연성을 높이고, 인프라 비용을 절감                                                                                                                                         |
| AWS Certificate Manager | HTTPS 보안 연결을 위해 SSL/TLS 인증서를 적용하여 데이터의 보안을 강화하고 신뢰성 있는 서비스를 제공                                                                                                                              |
| RDS                     | 신속하고 안정적인 데이터베이스 서비스를 구축하여 데이터 관리 및 확장성을 확보하고, 서비스 가용성을 높임                                                                                                                                  | |
| RESTDocs                | API 명세서 작성을 위해 사용                                                                                                                                                                           |


## 4. API 명세서
https://letmec.p-e.kr/docs/index.html
