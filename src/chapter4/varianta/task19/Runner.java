package chapter4.varianta.task19;

import java.util.List;

//19. Создать объект класса Фотоальбом, используя классы Фотография,
//Страница. Методы: задать название фотографии, дополнить фотоальбом
//фотографией, вывести на консоль количество фотографий.
public class Runner {
    public static void main(String[] args) {
        Photo photo = new Photo("My photo");
        Photo photo1 = new Photo("Some photo");
        Photo photo2 = new Photo("Winter");
        photo.setName("My new Photo");

        Page page1 = new Page();
        page1.addPhotoToPage(photo);
        page1.addPhotoToPage(photo1);
        page1.addPhotoToPage(photo2);
        page1.addPhotoToPage(photo2);


        Page page2 = new Page();
        page2.addPhotoToPage(photo);
        page2.addPhotoToPage(photo2);
        page2.addPhotoToPage(photo2);

        Page page3 = new Page();


        PhotoAlbum photoAlbum = new PhotoAlbum("My album");
        photoAlbum.addPage(page1);
        photoAlbum.addPage(page2);
        photoAlbum.addPage(page3);

        System.out.println(photoAlbum.quantityPage());




        System.out.println(photoAlbum.quantityPhoto());



    }
}
