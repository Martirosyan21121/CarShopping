package com.tesla.module;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "photos")
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String path;
    @JoinColumn(name = "file_name")
    private String fileName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car carId;
}
