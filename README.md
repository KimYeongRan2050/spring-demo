h2-console창이 나타나면
question_list에 파일이 없기 때문에 

http://localhost:8080/question/list 제목과 작성일시 만 나타나기 때문에
H2콘솔에 임시 데이터를 만듬


INSERT INTO question (subject, content, create_date)
VALUES ('첫 번째 질문', '첫 번째 질문 내용', CURRENT_TIMESTAMP);

INSERT INTO question (subject, content, create_date)
VALUES ('두 번째 질문', '두 번째 질문 내용', CURRENT_TIMESTAMP);

INSERT INTO question (subject, content, create_date)
VALUES ('세 번째 질문', '세 번째 질문 내용', CURRENT_TIMESTAMP);

INSERT INTO question (subject, content, create_date)
VALUES ('네 번째 질문', '네 번째 질문 내용', CURRENT_TIMESTAMP);

INSERT INTO question (subject, content, create_date)
VALUES ('다섯 번째 질문', '다섯 번째 질문 내용', CURRENT_TIMESTAMP);
