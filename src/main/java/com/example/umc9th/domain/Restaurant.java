package com.example.umc9th.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(columnDefinition = "TEXT")
    private String thumbnails;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(name = "rating", nullable = false)
    @Builder.Default
    private Integer rank = 0;

    @Column(length = 100)
    private String time;

    @Column(columnDefinition = "TEXT")
    private String review;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // 연관관계
    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Location location;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<RestaurantMission> restaurantMissions = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<PointHistory> pointHistories = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Qna> qnas = new ArrayList<>();
}
