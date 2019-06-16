package technicalblog.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Post {

    public Date date;
    public String title;
    public String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
