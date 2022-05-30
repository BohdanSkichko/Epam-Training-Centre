package chapter4.varianta.task19;

import java.util.ArrayList;
import java.util.List;

public class Page {
    private static final int LIMIT_PHOTO_PAGE = 4;
    private  final List<Photo> photoList = new ArrayList<>();

    public Page() {
    }

    public  boolean isFullPage() {
        return  photoList.size() % LIMIT_PHOTO_PAGE == 0;

    }

    public  List<Photo> getPhotoList() {
        return photoList;
    }


}
