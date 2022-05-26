package chapter4.varianta.task19;

import java.util.ArrayList;
import java.util.List;

public class Page {
    private static final int limitPagePhoto = 4;
    private static final List<Photo> photoList = new ArrayList<>();

    public Page() {
    }

    public static boolean isFullPage() {
        return  photoList.size() % limitPagePhoto == 0;

    }

    public  List<Photo> getPhotoList() {
        return photoList;
    }


}
