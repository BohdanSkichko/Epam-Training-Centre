package chapter4.varianta.task19;

import java.util.ArrayList;
import java.util.List;


public class PhotoAlbum {
    private String name;
    private List<Page> pageList = new ArrayList<>();


    void addPage(Page somePage) {
        pageList.add(somePage);
    }


    int quantityPage(){
        return  pageList.size();
    }

    int quantityPhoto() {
        int quantity = 0;
        for (int i = 0; i < pageList.size(); i++) {
            quantity += pageList.get(i).getPhotoList().size();
        }

        return quantity;
    }

    public PhotoAlbum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Page> getPageList() {
        return pageList;
    }
}
