/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coaextraction;

/**
 *
 * @author User
 */
public class COAExtraction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        NLPCoreExtractor extractor = NLPCoreExtractor.getInstance();
//        extractor.extractActionTreeBasedApproach1("Use a firewall to block all incoming connections from the Internet to services that should not be publicly available.");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabbedPane().setVisible(true);
            }
        });
    }
    
}
