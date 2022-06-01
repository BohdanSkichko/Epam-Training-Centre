package chapter5.task8city;

public class Runner {
    public static void main(String[] args) {

        City.AddressInfo address = new City.AddressInfo();

        Street street = new Street("Peremogu",23);
        Square square = new Square("Majdan",21);
        Avenue avenue = new Avenue("Bendera", 1);
        Street street1 = new Street("Svobodu", 2);
        Avenue avenue1 = new Avenue("Chokolovka", 110);

        address.addStreet(street);
        address.addStreet(street1);
        address.addAvenue(avenue);
        address.addSquare(square);
        address.addAvenue(avenue1);

        City city = new City("Kyiv",address);

        System.out.println(city);




    }


}
