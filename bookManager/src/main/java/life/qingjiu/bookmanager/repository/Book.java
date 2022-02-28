package life.qingjiu.bookmanager.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    private long BOOK_ID;

    private String bookName;
    private String province;
    private String city;
    private String county;
    private String locale;
    private String timeCreated;
    private String timeModified;

    public long getBOOK_ID() {
        return this.BOOK_ID;
    }

    public String getBookName(){
        return this.bookName;
    }

    public String getProvince(){
        return this.province;
    }

    public String getCity(){
        return this.city;
    }

    public String getCounty(){
        return this.county;
    }

    public String getLocale(){
        return this.locale;
    }

}
