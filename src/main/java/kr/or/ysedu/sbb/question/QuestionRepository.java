package kr.or.ysedu.sbb.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
  Question findBySubject(String subject);
  Question findBySubjectAndContent(String subject, String content);
  List<Question> findBySubjectLike(String subject);
  Page<Question> findAll(Pageable pageable);
  Page<Question> findAll(Specification<Question> spec, Pageable pageable);

  @Query("select "
      + "distinct q "
      + "from Question q "
      + "left outer join SiteUser u1 on q.author=u1 "
      + "left outer join Answer a on a.question=q "
      + "left outer join SiteUser u2 on a.author=u2 "
      + "where "
      + "   q.subject like %:kw% "
      + "   or q.content like %:kw% "
      + "   or u1.username like %:kw% "
      + "   or a.content like %:kw% "
      + "   or u2.username like %:kw% ")
  Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}
/*
== 리포지터리 생성하기 ==
파일명은 QuestionRepository 지정하며
interface로 인터페이스를 생성한다.


엔티티가 데이터베이스 테이블을 생성했다면
리포지터리는 이와 같이 생성된 데이터베이스 테이블의 데이터들을
저장, 조회, 수정, 삭제 등 할 수 있도록 도와주는 인터페이스이다.
*/