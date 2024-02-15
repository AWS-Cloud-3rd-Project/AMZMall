package com.amzmall.project.qna.domain.entity;

import com.amzmall.project.qna.domain.dto.ReplyResDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reply")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id", nullable = false)
    private Long replyId;

    @Column(length = 2000)
    private String replyContent;

    @Column
    private String admin;

    @OneToOne(mappedBy = "reply")
    private Question question;

    public ReplyResDto toReplyDto() {
        return ReplyResDto.builder()
            .replyId(replyId)
            .replyContent(replyContent)
            .admin(admin)
            .questionId(question.getQuestionId())
            .build();
    }
}


