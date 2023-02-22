package capstone.agora.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NOTICE_ID")
    private Long id; // pk

    @Column(name = "AUTHOR")
    private String author; // 작성자

    @Column(name = "TITLE")
    private String title; // 제목

    @Column(name = "QUESTION")
    private String question; // 질문

    @Column(name = "ANSWER")
    private String answer; // 답변

    @Column(name = "DATETIME")
    private LocalDateTime time; // 작성 시간
}
