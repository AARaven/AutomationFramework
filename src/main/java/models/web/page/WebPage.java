package models.web.page;

import java.net.URL;

public interface WebPage {
    
    void next();
    
    void back();
    
    void refresh();
    
    void open();
    
    void open( URL url );
    
    void close();
}
