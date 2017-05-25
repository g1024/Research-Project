/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportpreprocessornlp;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 *
 * @author mahmed27
 */
public class ReportPreprocessorNLP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException, XPathExpressionException {
//        HtmlParser parser = new HtmlParser();
//        String content = parser.traverseAllAlphabet();
//        NLPCoreExtractor extractor = NLPCoreExtractor.getInstance();
        //("The Trojan may arrive on the compromised computer after being downloaded by website");//
//        extractor.extractActionTreeBasedApproach("Check if the current user is an administrator.");
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        extractor.extractActionTreeBasedApproach("The Trojan may arrive on the compromised computer after being downloaded by website."); //When the Trojan is executed, it creates the following file
//        extractor.preProcessText("dssf [https://]www.amazon.com/Men-War-PC/dp/B001QZGVEC/EsoftTeam/watchc[REMOVED]");
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Preprocessor().setVisible(true);
            }
        });
    }
    
}
