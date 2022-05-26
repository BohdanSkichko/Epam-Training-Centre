package chapter4.varianta.task19;

import java.util.ArrayList;
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

        PhotoAlbum photoAlbum = new PhotoAlbum(5);

        photoAlbum.addPhoto(photo);
        photoAlbum.addPhoto(photo1);
        photoAlbum.addPhoto(photo);
        photoAlbum.addPhoto(photo2);
        photoAlbum.addPhoto(photo);
        photoAlbum.addPhoto(photo);
        photoAlbum.addPhoto(photo1);
        photoAlbum.addPhoto(photo);
        photoAlbum.addPhoto(photo2);
        photoAlbum.addPhoto(photo);
        photoAlbum.addPhoto(photo);
        photoAlbum.addPhoto(photo1);
        photoAlbum.addPhoto(photo);
        photoAlbum.addPhoto(photo2);
        photoAlbum.addPhoto(photo);
        photoAlbum.addPhoto(photo);
        photoAlbum.addPhoto(photo1);
        photoAlbum.addPhoto(photo);
        photoAlbum.addPhoto(photo2);
        photoAlbum.addPhoto(photo);
//        photoAlbum.addPhoto(photo);


        System.out.println(photoAlbum.getPageList().size());
        System.out.println(photoAlbum.quantityPhoto());
    }
}
