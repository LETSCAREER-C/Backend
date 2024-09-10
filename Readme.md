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

![_letscareer drawio](https://github.com/user-attachments/assets/7f1e46ab-4dd8-4be1-b12b-bf770d00af35)

1. 성능 최적화
   - 엘라스틱 캐시를 활용해 캐싱 적용
2. 외부공격대응
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


## 4. 부하 테스트
렛츠커리어에 들어오는 고객들은 공통적으로 프로그램 리스트 페이지를 보게됩니다.</br>
해당 API에 대해 부하 테스트를 진행했습니다. 

**Server spec**
</br>SpringBoot : 3.3.2
</br>EC2 : t2.micro
</br>RDS : t3.micro

**Test tool**
</br>k6 : v0.50.0

**캐싱 적용 전**
| **100명의 유저가 1초동안 최대 요청** | **30초 동안 최대 350명이 랜덤하게 요청을 보냄** |
| --- | --- |
|![100vus_1s](https://github.com/user-attachments/assets/82971f83-5ce0-4d7c-a17a-c2427d23896b) |![30s_vus350](https://github.com/user-attachments/assets/0aafcc43-e310-445f-8d0b-6ec2e181f276)  |
| **응답 시간** </br> 최대 : 780.87ms </br> 최소 : 39.6ms </br> 평균 : 269.59ms </br> **초당 처리량 (throughput)** : 313.459174/s | **응답 시간** </br> 최대 : 3.12s </br> 최소 : 20.13ms </br>평균 : 1.05s </br> **초당 처리량 (throughput)** : 237.66414/s |


**캐싱 적용 후**
| **100명의 유저가 1초동안 최대 요청** | **30초 동안 최대 350명이 랜덤하게 요청을 보냄** |
| --- | --- |
|![image](https://github.com/user-attachments/assets/0c936966-85e4-4c2b-afe7-90696329e54a) |![image](https://github.com/user-attachments/assets/c0503e16-94eb-4d60-9e64-6017e228ccb5) |
| **응답 시간** </br> 최대 : 198.11ms </br> 최소 : 24.08ms </br> 평균 : 113.97ms </br> **초당 처리량 (throughput)** : 754.704524/s | **응답 시간** </br> 최대 : 2.98s </br> 최소 : 11.14ms </br>평균 : 325.44ms </br> **초당 처리량 (throughput)** : 723.163924/s |


캐싱을 적용한 뒤 **초당처리량(throughput) 2.4배 증가**


---

구글 리서치에 따르면 응답시간이 5s를 넘어가면 90% 이상의 유저가 이탈합니다. </br>
응답을 받을 때 까지 5s가 걸리는지 확인하기 위해 테스트를 진행했습니다.

| **350명의 유저가 1초동안 최대 요청** |
| --- |
|![350vus_1s_5s](https://github.com/user-attachments/assets/58a29124-ba6c-4b5f-8f98-962083f180b2)|
| **checks**가 100% 로 모든 요청이 5s 이내임을 확인. |

| **360명의 유저가 1초동안 최대 요청** | **361명의 유저가 1초동안 최대 요청** |
| --- | --- |
|![image](https://github.com/user-attachments/assets/ba9fb686-b35f-4a42-a3ef-e9abd7398d07)  |![image](https://github.com/user-attachments/assets/97e67f90-86b8-4029-a3fc-2e188434e253)  |
| 실패율 : 0.00%  | 실패율: 0.32 % |

-> 임계 부하는 초당 361명이 최대요청


## 5. API 명세서
https://letmec.p-e.kr/docs/index.html

