# TRIPTON

**고민을 가방에 담아 저장하고 전체 목록에서 확인하는 서비스**

<sub>해당 파일은 기능 서술에 초점을 두고 있습니다. 기술적 의사 고민 등과 같은 부분은 <a href="https://nippyclouding.github.io/project.html">포트폴리오</a>에서 확인할 수 있습니다.</sub>

사용자가 자신의 고민을 가방 유형과 함께 제출하면 H2 메모리 데이터베이스에 저장됩니다.<br>
결과 페이지에서 저장된 가방(고민) 목록을 볼 수 있습니다.

---

<img width="643" height="574" alt="대표이미지" src="https://github.com/user-attachments/assets/f112c711-ca01-41c4-867a-b29661902be4" />

---

### 개발 과정 & 사용 기술

**개발 기간**
- 2개월 (2025.08.~2025.09.)
- 건국대 시각 영상 디자인학부 졸업 전시 웹 프로젝트 (운영 기간 5일)

**개발 인원**
- 2명 (디자이너 1명, 개발자 1명)

**개발 환경**
- **Language & DB**: Java 21, H2 in-memory DB
- **Framework**: Spring Boot 3 with JPA (Spring Data JPA)
- **Auth**: Admin Session & Cookie
- **Frontend**: Javascript, Thymeleaf (Server Side Rendering)
- **Infrastructure**: AWS EC2 & Docker Container
  - Spring Boot Container
  - NginX Container

---

### 1. ERD

<img width="1618" height="999" alt="ERD" src="https://github.com/user-attachments/assets/cfb69d9e-1e9d-4ed0-8070-0e9c5af6a977" />

<p align="center">
  <a href="https://www.erdcloud.com/d/n5g78GXYfmokFXqiN">ERDCloud에서 자세히 보기</a>
</p>

---

### 2. SYSTEM ARCHITECTURE

<img width="1027" height="918" alt="SystemArchitecture" src="https://github.com/user-attachments/assets/5ae960d9-f287-4ad9-9db6-831555ff84fd" />


---

### 3. 주요 기능

#### **가방 종류 선택**
사용자는 고민을 담을 가방을 총 3가지 중 하나 선택할 수 있습니다.

<img width="1870" height="949" alt="가방선택" src="https://github.com/user-attachments/assets/4edda114-fa59-47db-9572-96006528b653" />


#### **고민 입력**
사용자는 자신의 고민을 입력창에 입력할 수 있습니다.

<img width="735" height="848" alt="고민" src="https://github.com/user-attachments/assets/0170249d-7041-4130-80b5-568e3675a263" />

#### **고민 게시글 전체 조회**
사용자는 전체 고민들을 조회할 수 있습니다. (페이징 처리)

<img width="765" height="613" alt="고민리스트" src="https://github.com/user-attachments/assets/64212bad-79ef-4e23-ac7b-fd14f882b804" />


#### **관리자 페이지**

총 고민 수와 고민 목록을 관리자 화면에서 확인할 수 있습니다.

<img width="1895" height="985" alt="관리자" src="https://github.com/user-attachments/assets/34fc5568-d5fa-465b-9fd8-9c46d27a4736" />

---

### 4. 시연

TripToN의 주요 화면 흐름과 기능 동작을 영상으로 확인할 수 있습니다.

<a href="https://youtu.be/wkFMnX2pCsY">
  <img src="https://img.shields.io/badge/YouTube-시연%20영상%20보러가기-FF0000?style=for-the-badge&logo=youtube&logoColor=white" alt="시연 영상 보러가기" />
</a>
# graduation-exhibition-project
