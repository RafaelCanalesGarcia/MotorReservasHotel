package com.example.motorreservashotel.data_loader;

import com.example.motorreservashotel.entity.Hotel;
import com.example.motorreservashotel.repository.HotelRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final HotelRepository hotelRepository;

    public DataLoader(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        if (hotelRepository.count() < 20) {
            for (int i = 0; i < 20; i++) {

                Hotel hotel = new Hotel();

                hotel.setName(faker.company().name() + " Hotel");

                hotel.setStars(faker.number().numberBetween(1, 6));

                hotel.setCity(faker.address().city());

                hotel.setCountry(faker.address().country());

                hotel.setAddress(faker.address().streetAddress());

                hotelRepository.save(hotel);
            }
        }
    }
}
