package capstone.agora.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NOTICE")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NOTICE_ID")
    private Long id; // pk

    @Column(name = "NOTICE_NUM")
    private int num; // 글 번호

    @Column(name = "AUTHOR")
    private String author; // 작성자

    @Column(name = "TITLE")
    private String title; // 제목

    @Column(name = "CONTEXT")
    private String context; // 내용

    @Column(name = "DATETIME")
    private LocalDateTime time; // 작성 시간

}
