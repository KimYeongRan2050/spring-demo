package kr.or.ysedu.sbb.question;

import jakarta.persistence.*;
import kr.or.ysedu.sbb.answer.Answer;
import kr.or.ysedu.sbb.user.SiteUser;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
  @Id   //id 속성에 적용한 @id 애너테이션은 id 속성을 기본키로 지정
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //GeneratedValue 애너테이션을 적용하며 데이터를 저장할 때
  //해당 속성에 값을 일일이 입력하지 않아도 자동으로 1씩 증가하여 저장된다.
  private Integer id;

  @Column(length = 200)
  //엔티티의 속성은 테이블의 열 이름과 일치 하는데 열의 세부 설정을 위해 @Column 애너테이션을 사용한다.
  //length는 열의 길이를 설정할 때 사용하고 여기에서는 열의 길이를 200으로 정함
  private String subject;

  @Column(columnDefinition = "TEXT")
  //columnDefinition = "TEXT" 말 그대로 '텍스트'를 열 데이터로 넣을 수 있음을 의미
  private String content;

  private LocalDateTime createDate;

  @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
  private List<Answer> answerList;
  //Answer 객체들로 구성된 answerList를 Question 엔티티의 속성으로 추가하고
  //@OneToMany 애너테이션을 설정
  //질문에서 답변을 참조하려면 question.getAnswerList()를 호출
  //@OneToMany 애너테이션에 사용된 mappedBy는 참조 엔티티의 속성명을 정의
  //즉, Answer 엔티티에서 Question 엔티티를 참조한 속성인 question을 mappedBy에 전달해야 한다.

  @ManyToOne
  private SiteUser author;

  private LocalDateTime modifyDate;
}
