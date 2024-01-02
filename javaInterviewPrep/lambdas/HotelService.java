package javaInterviewPrep.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HotelService {

    static List<Hotel> hotelList = new ArrayList<>();

    public HotelService() {

        Hotel hotel1 = new Hotel(3000, 4, HotelType.FOUR_STAR);
        Hotel hotel2 = new Hotel(2333, 2, HotelType.THREE_STAR);
        Hotel hotel3 = new Hotel(1222, 3, HotelType.FOUR_STAR);
        Hotel hotel4 = new Hotel(3222, 5, HotelType.FIVE_STAR);

        hotelList.add(hotel1);
        hotelList.add(hotel2);
        hotelList.add(hotel3);
        hotelList.add(hotel4);


    }

//    public List<Hotel> filterHotelsLessThan(int price) {
//        List<Hotel> filteredHotels = new ArrayList<>();
//
//        for(Hotel hotel : hotelList) {
//            if(isHotelLessThan(price, hotel))
//                filteredHotels.add(hotel);
//        }
//        return filteredHotels;
//    }
//
//    private static boolean isHotelLessThan(int price, Hotel hotel) {
//        return hotel.getPricePerNight() <= price;
//    }
//
//    public List<Hotel> filterHotelsBy5Star() {
//        List<Hotel> filteredHotels = new ArrayList<>();
//
//        for(Hotel hotel : hotelList) {
//            if(isHotel5Star(hotel))
//                filteredHotels.add(hotel);
//        }
//        return filteredHotels;
//    }
//
//    private static boolean isHotel5Star(Hotel hotel) {
//        return hotel.getHotelType().equals(HotelType.FIVE_STAR);
//    }

    public List<Hotel> filterHotels(Predicate<Hotel> filteringCondition) {
        List<Hotel> filteredHotels = new ArrayList<>();

        for(Hotel hotel : hotelList) {
            if(filteringCondition.test(hotel))
                filteredHotels.add(hotel);
        }
        return filteredHotels;
    }
}
