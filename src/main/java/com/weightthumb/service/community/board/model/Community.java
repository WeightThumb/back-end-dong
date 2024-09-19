package com.weightthumb.service.community.board.model;

import com.weightthumb.service.login.client.model.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "community")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "writer_id", referencedColumnName = "id")
    private Member member;

    private String title;
    private String content;
    private String imagePath;
    private String category;
    private Timestamp createdAt;
}
