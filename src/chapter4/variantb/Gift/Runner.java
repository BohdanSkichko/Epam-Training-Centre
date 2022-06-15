package chapter4.variantb.Gift;

import chapter4.variantb.Gift.sweets.Caramel;
import chapter4.variantb.Gift.sweets.Chocolate;
import chapter4.variantb.Gift.sweets.Cookie;
import chapter4.variantb.Gift.sweets.SweetLogicException;

public class Runner {
    public static void main(String[] args) {
        try {
            Caramel caramel = new Caramel(20, 23);

            Chocolate chocolate = new Chocolate(33.3, 50);
            Caramel caramel2 = new Caramel(23.2, 150);
            Caramel caramel1 = new Caramel(20.1, 20);
            Cookie cookie = new Cookie(23, 24);

            Gift gift1 = new Gift();
            gift1.addSweet(caramel);
            gift1.addSweet(caramel1);


            Gift gift = new Gift();
            gift.addSweet(caramel);
            gift.addSweet(chocolate);
            gift.addSweet(caramel2);
            gift.addSweet(caramel1);
            gift.addSweet(cookie);


            System.out.println(gift);

            gift.sortByWeight();
            System.out.println(gift);


            gift.sortBySugar();
            System.out.println(gift);


            System.out.println("range of sugar");
            System.out.println(gift.findSweets(-1, 24));


        } catch (SweetLogicException | GiftLogicException e) {
            System.out.println("Exception thrown" + e.getMessage());
        }


    }
}
