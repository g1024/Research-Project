/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawler;

import URLData.URLRepository;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author mahmed27
 */
public class ThreatExpertHtmlPerser {
    private String urlPath = "/report.aspx?md5=";
    private Document htmlDocument;
    public ThreatExpertHtmlPerser() {
        htmlDocument = null;
    }
    
    public void setHtmlDocument(String hash) throws IOException {
        htmlDocument = Jsoup.connect(URLRepository.threatExpertURL + urlPath + hash).get();
        System.out.println(htmlDocument.select("td").text());
    }
    
    
    
}
