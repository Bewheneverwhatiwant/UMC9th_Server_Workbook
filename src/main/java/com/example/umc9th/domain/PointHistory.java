package com.example.umc9th.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "point_history")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PointHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime receivedAt;

    @Column(nullable = false)
    @Builder.Default
    private Boolean isWithdraw = false;

    @Column(nullable = false)
    @Builder.Default
    private Integer plusPoint = 0;

    @Column(nullable = false)
    @Builder.Default
    private Integer minusPoint = 0;
}
