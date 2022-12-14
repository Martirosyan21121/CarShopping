package com.tesla.module;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String model;
    @Enumerated(value = EnumType.STRING)
    @JoinColumn(name = "inventory_type")
    private InventoryType inventoryType;
    private String color;
    @JoinColumn(name = "date_of_creation")
    private Date dateOfCreation;
    @JoinColumn(name = "power_reserve")
    private int powerReserve;
    @JoinColumn(name = "max_speed")
    private int maxSpeed;
    @JoinColumn(name = "up_to_sixty")
    private double upToSixty;

    private int price;
    @JoinColumn(name = "car_code")
    private String carCode;

    @Lob
    @Column(name = "image_one", columnDefinition = "BLOB")
    private byte[] imageOne;

    @JoinColumn(name = "image_two")
    private String imageTwo;

    @JoinColumn(name = "image_three")
    private String imageThree;

    @JoinColumn(name = "image_four")
    private String imageFour;

    @JoinColumn(name = "image_five")
    private String imageFive;

    @JoinColumn(name = "image_six")
    private String imageSix;
    @Enumerated(value = EnumType.STRING)
    private AutopilotType autopilot;
    private int weight;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && powerReserve == car.powerReserve && maxSpeed == car.maxSpeed && Double.compare(car.upToSixty, upToSixty) == 0 && price == car.price && weight == car.weight && Objects.equals(model, car.model) && inventoryType == car.inventoryType && Objects.equals(color, car.color) && Objects.equals(dateOfCreation, car.dateOfCreation) && Objects.equals(carCode, car.carCode) && Objects.equals(imageOne, car.imageOne) && Objects.equals(imageTwo, car.imageTwo) && Objects.equals(imageThree, car.imageThree) && Objects.equals(imageFour, car.imageFour) && Objects.equals(imageFive, car.imageFive) && Objects.equals(imageSix, car.imageSix) && autopilot == car.autopilot && Objects.equals(user, car.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, inventoryType, color, dateOfCreation, powerReserve, maxSpeed, upToSixty, price, carCode, imageOne, imageTwo, imageThree, imageFour, imageFive, imageSix, autopilot, weight, user);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", inventoryType=" + inventoryType +
                ", color='" + color + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", powerReserve=" + powerReserve +
                ", maxSpeed=" + maxSpeed +
                ", upToSixty=" + upToSixty +
                ", price=" + price +
                ", carCode='" + carCode + '\'' +
                ", imageOne='" + imageOne + '\'' +
                ", imageTwo='" + imageTwo + '\'' +
                ", imageThree='" + imageThree + '\'' +
                ", imageFour='" + imageFour + '\'' +
                ", imageFive='" + imageFive + '\'' +
                ", imageSix='" + imageSix + '\'' +
                ", autopilot=" + autopilot +
                ", weight=" + weight +
                ", user=" + user +
                '}';
    }
}
