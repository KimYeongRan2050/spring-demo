package kr.or.ysedu.sbb.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
  Question findBySubject(String subject);
  Question findBySubjectAndContent(String subject, String content);
  List<Question> findBySubjectLike(String subject);
  Page<Question> findAll(Pageable pageable);
}
/*
== 리포지터리 생성하기 ==
파일명은 QuestionRepository 지정하며
interface로 인터페이스를 생성한다.


엔티티가 데이터베이스 테이블을 생성했다면
리포지터리는 이와 같이 생성된 데이터베이스 테이블의 데이터들을
저장, 조회, 수정, 삭제 등 할 수 있도록 도와주는 인터페이스이다.
*/