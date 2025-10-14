package com.example.umc9th.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alarms")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    @Builder.Default
    private Boolean active = false;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // 연관관계
    @OneToMany(mappedBy = "alarm", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<AlarmAgree> alarmAgrees = new ArrayList<>();
}
