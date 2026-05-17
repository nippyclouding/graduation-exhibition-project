package server.TripToN.concern.entity;

import server.TripToN.global.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@Table(name = "CONCERNS")
public class Concern extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "concern_id")
    private Long concernId;

    @Column(nullable = false, length = 255)
    private String concernTitle;

    @Column(columnDefinition = "TEXT")
    private String concernContent;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LuggageType luggageType;
}
