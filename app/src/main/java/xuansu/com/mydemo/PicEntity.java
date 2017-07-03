package xuansu.com.mydemo;

/**
 * Created by xuansu on 2017/7/3.
 */

public class PicEntity {

    int   title;
    String path;
    String  name;

    public PicEntity(int  title, String path, String name) {
        this.title = title;
        this.path = path;
        this.name = name;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
