package life.qingjiu.bookmanager.entity;

import lombok.Data;

@Data
public class Book {
    private long BOOK_ID;
    private String bookName;
    private String province;
    private String city;
    private String county;
    private String locale;
}
