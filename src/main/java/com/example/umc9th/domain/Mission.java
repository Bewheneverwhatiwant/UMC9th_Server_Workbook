package com.example.umc9th.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "missions")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String restaurant;

    @Column(nullable = false)
    private Integer money;

    @Column(nullable = false)
    private Integer point;

    @Column(nullable = false)
    private LocalDate leftDate;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // 연관관계
    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<UserMission> userMissions = new ArrayList<>();

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<RestaurantMission> restaurantMissions = new ArrayList<>();

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<PointHistory> pointHistories = new ArrayList<>();
}
