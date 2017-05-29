/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawler;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mahmed27
 */
public class WebCrawler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ThreatExpertHtmlPerser parser = new ThreatExpertHtmlPerser();
        try {
            parser.setHtmlDocument("5a309c6b0d5e35f67a04994a821b2e392");
        } catch (IOException ex) {
            Logger.getLogger(WebCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
