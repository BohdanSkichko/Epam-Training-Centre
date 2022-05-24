package chapter4.varianta.task19;

import java.util.ArrayList;
import java.util.List;

public class Page {
    private static int pageCount = 0;
    private int pageId;
    private List<Photo> photoList = new ArrayList<>();

    void addPhotoToPage(Photo somePhoto) {
        photoList.add(somePhoto);
    }

    public static int getPageCount() {
        return pageCount;
    }

    public static void setPageCount(int pageCount) {
        Page.pageCount = pageCount;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public Page() {
        pageCount++;
        this.pageId = pageCount;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }
}
