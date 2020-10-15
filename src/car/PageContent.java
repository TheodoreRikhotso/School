/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

/**
 *
 * @author rikho
 */
public class PageContent {
    private String link;
    private String tittle;
    private String content;

    public PageContent() {
    }

    public PageContent(String link, String tittle, String content) {
        this.link = link;
        this.tittle = tittle;
        this.content = content;
    }
    
      public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
    
}
