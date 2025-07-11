# 💡 2025 CQRS 기반 아키텍처 Pre-onboarding Master Class

## Week 1-1: CQRS 패턴 - 확장성과 책임 분리를 위한 핵심 개념

- **핵심 개념**
    - Command / Query 책임 분리
    - CQRS 기본 구조
    - 트랜잭션 경계 재설계
- **왜 CQRS가 필요한가**
- **모놀리식 시스템에서의 한계**
- **Command와 Query 모델 분리의 효과**
- **실무 사례로 보는 적용 배경**
- **CQRS 패턴의 트레이드오프**
- **아하 모먼트**
    - 복잡한 도메인을 CQRS로 분리했더니 확장성과 유지보수성이 극적으로 향상되는 순간

---

## Week 1-2: 이벤트 기반 아키텍처 - 데이터 흐름의 비동기화 전략

- **핵심 개념**
    - Event Sourcing
    - Kafka / 메시지 브로커
    - CDC(Change Data Capture)
    - At-least-once / Exactly-once 전략
- **CQRS와 이벤트 기반 아키텍처의 연결**
- **Command → Event → Query 구조의 설계 방식**
- **비동기 전파의 장점과 단점**
- **이벤트 중복 처리 및 역추적 문제 대응법**
- **아하 모먼트**
    - 복잡한 Command 결과가 이벤트를 통해 Query 모델로 자연스럽게 반영되는 걸 목격한 순간

---

## Week 2-1: 읽기 모델 설계 - 사용자 중심의 최적화된 조회 모델 구축

- **핵심 개념**
    - Projection
    - 다중 데이터 스토어 전략
    - MongoDB / Elasticsearch / Redis 등 활용
    - 일관성 vs 가용성
- **Query 모델은 왜 따로 설계해야 하는가**
- **실시간성과 비동기성 사이의 균형**
- **조회 패턴 기반 최적화 설계**
- **CQRS에 적합한 읽기 저장소 선택법**
- **아하 모먼트**
    - 복잡한 SQL 대신 Redis나 Elasticsearch로 단숨에 해결하는 경험을 했던 순간

---

## Week 2-2: 운영과 최적화 - 장애 대응과 면접 전략까지

- **핵심 개념**
    - CQRS 장애 유형 분석
    - 캐싱 전략 (쓰기 후 갱신, 읽기 전 invalidation 등)
    - 지연 일관성 처리 방식
    - 모니터링 포인트와 알림 설계
- **데이터 불일치에 대한 실무 대응 전략**
- **CQRS 성능 최적화 기법**
- **CQRS 기반 시스템의 배포 전략**
- **CQRS를 포트폴리오와 면접에서 설명하는 법**
- **자주 나오는 면접 질문**
- **아하 모먼트**
    - 단순한 분리였던 CQRS가 실전 장애 대응과 성능 개선에 핵심 역할을 한다는 걸 이해한 순간
